package com.crawler.service;

import com.crawler.dao.PicMapper;
import com.crawler.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Pic> getPicList(Integer start, Integer offset, Integer category){
        return picMapper.getPicList(start, offset, category);
    }

    public Pic getGif(Integer id){
        return picMapper.selectByPrimaryKey(id);
    }
}
