package com.newland.nideshopserver.controller.comment;

import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.service.CommentService;
import com.newland.nideshopserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Year;
import java.util.HashMap;

/**
 * @author xzt
 * @CREATE2019-10-15 10:13
 */
@RestController
public class CommentController {

    @Autowired
    private UserService userService;


    @Autowired
    private CommentService commentService;

    /**
     * 评论
     *
     * @param valueId
     * @param typeId
     * @param showType
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/comment/list")
    public Result listAction(int valueId, int typeId, int size, Integer showType, Integer page) throws Exception {
        CountSelect countSelect = commentService.listService(typeId, valueId, size, showType, page);
        Result result = new Result();
        result.setData(countSelect);
        return result;
    }

    /**
     * 评论数量计算
     *
     * @param typeId
     * @param valueId
     * @return
     */
    @RequestMapping("/comment/count")
    public Result countAction(int typeId, int valueId) {
        int allCount = commentService.allCount(typeId, valueId);
        int hasPicCount = commentService.picCount(typeId, valueId);
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        map.put("allCount", allCount);
        map.put("hasPicCount", hasPicCount);
        result.setData(map);
        return result;
    }

    @RequestMapping("/comment/post")
    public Result postAction(int typeId, int valueId, String content, HttpServletRequest request) throws Exception {
        String token = request.getHeader("X-Nideshop-Token");
        Integer userId = userService.findByToken(token).getId();
        if (userId == null) {
            return Result.build(ResultCode.NO_AUTH.val(), ResultCode.NO_AUTH.msg(), null);
        }
        int i = commentService.postComment(typeId, valueId, content, userId);
        if (i > 0) {
            return Result.build(ResultCode.SUCCESS.val(),ResultCode.SUCCESS.msg(),null);
        }else {
            return Result.build(ResultCode.EXCEPTION.val(),ResultCode.EXCEPTION.msg(),null);
        }
    }


}
