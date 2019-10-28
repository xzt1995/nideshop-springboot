package com.newland.nideshopserver.controller.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.newland.nideshopserver.mapper.UserMapper;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.model.dto.UserInfo;
import com.newland.nideshopserver.service.UserService;
import com.newland.nideshopserver.utis.WechatUtil;
import com.sun.deploy.net.HttpRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import java.util.Date;
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


    @RequestMapping("/auth/loginByWeixin")
    public Result loginByWeixin(String code, UserInfo userInfo){
        // 用户非敏感信息：rawData
        // 签名：signature
        System.out.println(code);
        JSONObject rawDataJson = JSON.parseObject(userInfo.getRawData());
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appid + appsecret + code
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(userInfo.getRawData() + sessionKey);
        if (!userInfo.getSignature().equals(signature2)) {
            return Result.build(ResultCode.EXCEPTION.val(),ResultCode.EXCEPTION.msg(),null);
        }
        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        Example e = new Example(NideshopUser.class);
        e.selectProperties("weixinOpenid",openid);
        NideshopUser user = userMapper.selectOneByExample(e);
        // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
        String skey = UUID.randomUUID().toString();
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickname");
            String avatarUrl = rawDataJson.getString("avatar");
            String gender = rawDataJson.getString("gender");

            user = new NideshopUser();
            user.setWeixinOpenid(openid);
            user.setRegisterTime(new Date());
            user.setLastLoginTime(new Date());
            user.setAvatar(avatarUrl);
            user.setGender(Integer.parseInt(gender));
            user.setNickname(nickName);

            this.userMapper.insert(user);
        } else {
            // 已存在，更新用户登录时间
            user.setLastLoginTime(new Date());
            // 重新设置会话skey
            this.userMapper.updateByPrimaryKey(user);
        }
       // HttpSession session = request.getSession();
       // session.setAttribute("userInfo",user);
        //encrypteData比rowData多了appid和openid
        JSONObject u = WechatUtil.getUserInfo(userInfo.getEncryptedData(), sessionKey, userInfo.getIv());
        //6. 把新的skey返回给小程序
        return  Result.build(ResultCode.SUCCESS.val(), ResultCode.SUCCESS.msg(), null);
    }
}
