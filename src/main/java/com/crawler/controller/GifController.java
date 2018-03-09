package com.crawler.controller;

import com.alibaba.fastjson.JSONObject;
import com.crawler.model.Pic;
import com.crawler.service.CommentService;
import com.crawler.service.PicService;
import com.crawler.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2018/3/7.
 */
@RestController
public class GifController {

    @Autowired
    PicService picService;
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/getGifList", method = RequestMethod.GET)
    public JSONObject getPicList(@RequestParam Integer pageSize,
                                 @RequestParam Integer pageNum,
                                 @RequestParam Integer category) {
        Integer start = pageNum  * pageSize;
        Integer offset = pageSize;
        if(category.equals(-1)) category = null;
        List<Pic> list = picService.getPicList(start, offset, category);
        for(Pic pic : list){
            pic.setCommentList(commentService.getComments(pic.getId()));
        }
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/getGif", method = RequestMethod.GET)
    public JSONObject getGif(@RequestParam Integer id) {
        Pic pic = picService.getGif(id);
        pic.setCommentList(commentService.getComments(pic.getId()));
        return ResponseUtil.success(pic);
    }
}
