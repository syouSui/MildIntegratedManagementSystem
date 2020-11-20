package com.syousui.mildintegratedmanagesystem.pojo.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : ResultVo.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.pojo.vo
 * @createTime : 2020-11-20 12:58:00 星期五
 * @Description : TODO
 */

public class ResultVo {
    public static final int CODE_FAILED = 0;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_NOLOGIN = 2;
    public static final int CODE_AUTH_FAIL = 3;

    private int code;
    private String message;
    private Object data;

    public ResultVo ( ) {
    }

    public ResultVo ( int code, String message, Object data ) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode ( ) {
        return code;
    }

    public void setCode ( int code ) {
        this.code = code;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public Object getData ( ) {
        return data;
    }

}
