package com.wanwan.common.jsonview;

/**
 * 输出jsonview
 *
 * @author wanwan
 * @create 2016-12-14 上午10:52
 */
public class JsonView {
    private  Integer code;
    private String message;
    private Object object;

    public JsonView() {
    }
    public JsonView(Integer code) {
        this.code = code;
    }
    public JsonView(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonView(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
}
