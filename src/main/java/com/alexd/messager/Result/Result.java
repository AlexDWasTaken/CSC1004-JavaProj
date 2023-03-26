package com.alexd.messager.Result;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Boolean success;
    private Integer code;
    private String message;

    public Map<String, Object> getData() {
        return data;
    }

    private Map<String, Object> data = new HashMap<>();

    public static Result ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("Success");
        return r;
    }

    public static Result fail() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.FAILURE);
        r.setMessage("Plain Failure");
        return r;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Result setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
