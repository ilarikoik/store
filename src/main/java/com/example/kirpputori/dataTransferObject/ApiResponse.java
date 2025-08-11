package com.example.kirpputori.dataTransferObject;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResponse success(Object data) {
        String className = data != null ? data.getClass().getSimpleName() : "Object";
        return new ApiResponse(true, className + " added successfully", data);
    }

    public ApiResponse error(String message) {
        return new ApiResponse(false, message, null);
    }
}
