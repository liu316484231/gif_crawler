package com.crawler.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 16/11/18.
 */
public class ResponseUtil {

    private static final Logger logger = Logger.getLogger(ResponseUtil.class);
    public static final Integer SUCCESS = 200;
    public static final Integer FAILURE = 0;
    public static final Integer FAILURE_CODE_BADPARAMS = -1;
    public static final Integer FAILURE_CODE_SERVERERROR = -2;
    public static final Integer FAILURE_CODE_NOTMODIFIED = -3;
    public static final Integer FAILURE_CODE_NOTSUPPORTMETHOD = -4;
    public static final Integer FAILURE_CODE_ITEMEXIST = -5;
    public static final String CODE = "code";
    public static final String MESSAGE = "msg";
    public static final String EXTRA_MSG = "extra";
    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final String DATA = "data";
    public static final Map<Integer, String> FAILURE_CODE_MSG = new HashMap<Integer, String>();
    static {
        FAILURE_CODE_MSG.put(FAILURE, "操作失败");
        FAILURE_CODE_MSG.put(FAILURE_CODE_BADPARAMS, "参数错误");
        FAILURE_CODE_MSG.put(FAILURE_CODE_SERVERERROR, "服务器内部错误");
        FAILURE_CODE_MSG.put(FAILURE_CODE_NOTMODIFIED, "操作找不到任何数据");
        FAILURE_CODE_MSG.put(FAILURE_CODE_NOTSUPPORTMETHOD, "服务器不支持这种提交方式");
        FAILURE_CODE_MSG.put(FAILURE_CODE_ITEMEXIST, "数据已存在");
    }

    public static JSONObject success() {
        JSONObject result = new JSONObject();
        result.put(CODE, SUCCESS);
        result.put(MESSAGE, SUCCESS_MESSAGE);
        return result;
    }

    public static JSONObject success(Object obj) {
        JSONObject result = new JSONObject();
        result.put(CODE, SUCCESS);
        result.put(MESSAGE, SUCCESS_MESSAGE);
        if(obj == null){
            obj = new JSONObject();
        }
        result.put(DATA, obj);
        return result;
    }

    public static JSONObject sendResponse(int code, String msg, Object data){
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, msg);
        result.put(DATA, data);
        return result;
    }

    public static JSONObject error(int code){
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, FAILURE_CODE_MSG.get(code));
        return result;
    }

    public static JSONObject error(int code, String msg){
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, msg);
        return result;
    }

    public static JSONObject error(int code, String msg, String extra){
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, msg);
        result.put(EXTRA_MSG, extra);
        return result;
    }


}
