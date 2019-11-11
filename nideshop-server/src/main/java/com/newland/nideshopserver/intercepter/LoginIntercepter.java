package com.newland.nideshopserver.intercepter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.newland.nideshopserver.config.PublicPath;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.service.UserService;

/**
 * @author xzt @CREATE2019-10-23 11:38 登录验证
 */
@Component
public class LoginIntercepter extends HandlerInterceptorAdapter {

	private final static Logger log = LoggerFactory.getLogger(LoginIntercepter.class);

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.info("----------------登录拦截器--------------");

		String token = request.getHeader("X-Nideshop-Token");

		// 获取访问路径
		String path = request.getServletPath();
		// 获取controller名称
		String[] split = path.split("/");
		log.info("----------------登录拦截器--------------" + "拦截路径:" +path);
		List<String> controllers = Arrays.asList(PublicPath.getPublicController());
		List<String> actions = Arrays.asList(PublicPath.getPublicAction());
		if (!controllers.contains(split[1]) && !actions.contains(path)) {

			// 非公开路径，需要登录验证
			NideshopUser userInfo = userService.findByToken(token);

			if (token==null||userInfo == null) {
				log.info("用户未登录！");
				Result result = new Result();
				result.setErrno(ResultCode.NO_AUTH.val());
				result.setErrmsg(ResultCode.NO_AUTH.msg());
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(JSON.toJSON(result).toString());

				return false;
			} else {
				log.info("用户已经登录");
				return true;
			}
		}
		return true;
	}

}
