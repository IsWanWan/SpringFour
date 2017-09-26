package com.wanwan.domain;

import java.util.Date;

/**
 * Created by c_zhangyayun-001 on 2017/9/22.
 */
public class LogInfo {
    private int id;
    private int userId;
    private String module;
    private String method;
    private String responseData;
    private String ip;
    private Date date;
    private String commite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommite() {
        return commite;
    }

    public void setCommite(String commite) {
        this.commite = commite;
    }
}
