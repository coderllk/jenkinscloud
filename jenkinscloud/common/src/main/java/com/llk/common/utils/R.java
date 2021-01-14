package com.llk.common.utils;

import java.util.HashMap;
import java.util.Map;

public class R {
    int code;
    String msg;
    Map<String,Object> res = new HashMap<String, Object>();

    public static R ok(String key,Object value){
        R r = new R();
        r.code = 0;
        r.msg = "success";
        r.res.put(key,value);
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getRes() {
        return res;
    }

    public void setRes(Map<String, Object> res) {
        this.res = res;
    }
}
