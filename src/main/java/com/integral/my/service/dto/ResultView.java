package com.integral.my.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ResultView<T> implements Serializable {
    @ApiModelProperty(value = "状态值")
    private String status = "0";
    @ApiModelProperty(value = "返回提示消息")
    private String msg = "ok";
    @ApiModelProperty(value = "返回对应的数据对象")
    private T data;

    public ResultView() {
    }

    public ResultView(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultView(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultView(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
