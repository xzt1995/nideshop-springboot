package com.newland.nideshopserver.controller.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.newland.nideshopserver.mapper.UserMapper;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.model.dto.UserInfo;
import com.newland.nideshopserver.service.UserService;
import com.newland.nideshopserver.utis.Utis;
import com.newland.nideshopserver.utis.WechatUtil;
import com.sun.mail.imap.ModifiedSinceTerm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


/**
 * @author xzt
 * @CREATE2019-10-28 10:18
 */
@RestController
public class AuthController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;


    /**
     * 第一步：小程序通过wx.login()获取code。
     * 第二步：小程序通过wx.request()发送code到开发者服务器。
     * 第三步：开发者服务器接收小程序发送的code，并携带appid、appsecret（这两个需要到微信小程序后台查看）、code发送到微信服务器。
     * 第四步：微信服务器接收开发者服务器发送的appid、appsecret、code进行校验。校验通过后向开发者服务器发送session_key、openid。
     * 第五步：开发者服务器自己生成一个skey（自定义登录状态）与openid、session_key进行关联，并存到数据库中（mysql、redis等）。
     * 第六步：开发者服务器返回生成skey（自定义登录状态）到小程序。
     * 第七步：小程序存储skey（自定义登录状态）到本地。
     */
    @RequestMapping("/auth/loginByWeixin")
    public Result loginByWeixin(@RequestParam(value = "code", required = false) String code,
                                @RequestParam(value = "rawData", required = false) String rawData,
                                @RequestParam(value = "signature", required = false) String signature,
                                @RequestParam(value = "encrypteData", required = false) String encrypteData,
                                @RequestParam(value = "iv", required = false) String iv, HttpServletRequest request) throws Exception {
        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(rawData);
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appid + appsecret + code
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            return Result.build(ResultCode.EXCEPTION.val(),ResultCode.EXCEPTION.msg(),null);
        }
        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        Example e = new Example(NideshopUser.class);
        Example.Criteria criteria = e.createCriteria();
        criteria.andEqualTo("weixinOpenid", openid);
        NideshopUser user = userMapper.selectOneByExample(e);
        // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
        String token = UUID.randomUUID().toString();
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickname");
            String avatarUrl = rawDataJson.getString("avatar");
            String gender = rawDataJson.getString("gender");

            user = new NideshopUser();
            user.setWeixinOpenid(openid);
            user.setRegisterTime(System.currentTimeMillis()/1000);
            user.setLastLoginTime(System.currentTimeMillis()/1000);
            user.setAvatar(avatarUrl);
            user.setGender(Integer.parseInt(gender));
            user.setNickname(nickName);

            this.userMapper.insert(user);
        } else {
            // 已存在，更新用户登录时间
            user.setLastLoginTime(System.currentTimeMillis()/1000);
            // 重新设置会话skey
            this.userMapper.updateByPrimaryKey(user);
        }
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",user);
        //encrypteData比rowData多了appid和openid
        JSONObject u = WechatUtil.getUserInfo(encrypteData, sessionKey, iv);
        //6. 把新的skey返回给小程序

        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("userInfo",user);
        result.setData(map);
        return result;
    }
}
