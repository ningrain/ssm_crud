package com.gta.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 通用返回类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 16:13
 */
public class Message {

    //状态码
    private int code;
    //消息
    private String msg;
    //数据
    private Map<String, Object> map = new HashMap<String, Object>();

    public static Message success(){
        Message msg = new Message();
        msg.setCode(200);
        msg.setMsg("成功");
        return msg;
    }

    public static Message fail(){
        Message msg = new Message();
        msg.setCode(500);
        msg.setMsg("失败");
        return msg;
    }

    public Message builder(String k, Object v){
        this.map.put(k, v);
        return this;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
