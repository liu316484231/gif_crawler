package com.crawler.controller;

import com.crawler.util.ResponseUtil;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 16/11/18.
 */
@ControllerAdvice
public class ExceptionController {
    private static final Logger logger = Logger.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseUtil.error(ResponseUtil.FAILURE_CODE_SERVERERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public JSONObject handleMissingParamsException(MissingServletRequestParameterException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseUtil.error(ResponseUtil.FAILURE_CODE_BADPARAMS);
    }

    @ExceptionHandler(JSONException.class)
    @ResponseBody
    public JSONObject handleBadParamsException(JSONException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseUtil.error(ResponseUtil.FAILURE_CODE_BADPARAMS);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public JSONObject handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        logger.error(ex.getMessage(), ex);
        return ResponseUtil.error(ResponseUtil.FAILURE_CODE_NOTSUPPORTMETHOD);
    }

}
