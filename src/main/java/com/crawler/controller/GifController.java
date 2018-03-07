package com.crawler.controller;

import com.alibaba.fastjson.JSONObject;
import com.crawler.model.Pic;
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

    @RequestMapping(value = "/getGifList", method = RequestMethod.GET)
    public JSONObject getPicList(@RequestParam Integer pageSize,
                                 @RequestParam Integer pageNum,
                                 Integer category) {
        Integer start = pageNum  * pageSize;
        Integer offset = pageSize;
        List<Pic> list = picService.getPicList(start, offset, category);
        return ResponseUtil.success(list);
    }
}
