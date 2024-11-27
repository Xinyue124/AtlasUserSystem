package com.mybatis.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    public Boolean isSuccess;
    public Integer code=10000;
    public String message;
    public T data;

    public BaseResponse(T data){
        this.data=data;
        isSuccess=true;
        code=10000;
    }
    public BaseResponse(String msg){
        isSuccess=false;
        code=50000;
        message=msg;
    }



}
