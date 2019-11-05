package com.newland.nideshopserver.intercepter;

import com.newland.nideshopserver.config.PublicPath;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-23 11:38
 * 登录验证
 */
public class LoginIntercepter extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(LoginIntercepter.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();
        //获取访问路径
        String path = request.getServletPath();
        //获取controller名称
        String[] split = path.split("/");
        log.info("----------------登录拦截器----" + "拦截路径为：" + path + "----------");
        List<String> controllers = Arrays.asList(PublicPath.getPublicController());
        List<String> actions = Arrays.asList(PublicPath.getPublicAction());
        if (!controllers.contains(split[1]) && !actions.contains(path)) {

            //非公开路径，需要登录验证
            NideshopUser userInfo = (NideshopUser) session.getAttribute("userInfo");
            if (userInfo == null) {
                log.info("用户未登录！");
                Result result = new Result();
                result.setErrno(ResultCode.NO_AUTH.val());
                result.setErrmsg(ResultCode.NO_AUTH.msg());

                response.getWriter().print(result);
                return false;
            } else {
                log.info("用户已经登录");
                return true;
            }
        }
        return true;
    }

}
