package com.crawler.service;

import com.crawler.dao.PicMapper;
import com.crawler.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/3/6.
 */
@Service
public class PicService {

    @Autowired
    PicMapper picMapper;

    public void save(Pic pic){
        picMapper.save(pic);
    }
}
