package com.constructhub.backend.dto.response;


//neu de ResponseData<?> thi de kieu gi cung dc
public class ResponseData <T>{
    private int status;
    private String message;
    private T data;


    //PUT, PATCH, DELETE
    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }
    //GET POST

    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
