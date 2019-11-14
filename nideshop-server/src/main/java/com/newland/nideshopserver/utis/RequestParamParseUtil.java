package com.newland.nideshopserver.utis;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.service.UserService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月7日 上午10:35:06
 * @version V1.0
 */
@Component
public class RequestParamParseUtil {

	@Autowired
	private UserService userService;

	public NideshopUser getLoginUser(HttpServletRequest request) {
		String token = this.getToken(request);
		NideshopUser userInfo = userService.findByToken(token);
		return userInfo;
	}

	public String getToken(HttpServletRequest request) {
		String token = request.getHeader("X-Nideshop-Token");
		return token;
	}

	public Integer getUserId(HttpServletRequest request) {
		NideshopUser user = this.getLoginUser(request);
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}
}
