package com.crawler.controller;

import com.alibaba.fastjson.JSONObject;
import com.crawler.model.Pic;
import com.crawler.service.CommentService;
import com.crawler.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2018/3/8.
 */
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public JSONObject comment(@RequestParam Integer gid,
                              @RequestParam String comment,
                              @RequestParam String user) {
        commentService.save(gid, comment, user);
        return ResponseUtil.success();
    }
}
