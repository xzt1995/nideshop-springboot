package com.newland.nideshopserver.controller.search;

import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.KeywordsService;
import com.newland.nideshopserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xzt
 * 首页搜索框
 * @CREATE2019-11-19 10:23
 */
@RestController
public class SearchController {

    @Autowired
    private KeywordsService keywordsService;

    @Autowired
    private UserService userService;

    @RequestMapping("/search/index")
    public Result indexAction(HttpServletRequest request){
        String token = request.getHeader("X-Nideshop-Token");
        NideshopUser user = userService.findByToken(token);
        Integer userId = user.getId();
        // 取出输入框默认的关键词
        Result result = keywordsService.index(userId);
        return result;
    }
}
