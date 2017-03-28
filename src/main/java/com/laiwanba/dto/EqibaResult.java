package com.laiwanba.dto;

import java.util.List;

/**
 * Created by chunmiao on 17-3-5.
 */
public class EqibaResult<T> {
    //成功标志
    private int success;
    //错误信息
    private String errorMsg;
    //返回数据
    private List<T> data;

    public EqibaResult(int success, List<T> data) {
        this.success = success;
        this.data = data;
    }

    public EqibaResult(int success, String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LaiwanbaResult{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
