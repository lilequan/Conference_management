package org.example.conference_management.pojo;

import lombok.Data;

@Data
public class R {
    private int state;
    private String message;
    private Object data;

    public static R  SUCCESS(Object data){
        R r = new R();
        r.setState(200);
        r.setMessage("success");
        r.setData(data);
        return r;
    }

    public static R  ERROR(Object data){
        R r = new R();
        r.setState(-1);
        r.setMessage(data.toString());
        r.setData(null);
        return r;
    }
}
