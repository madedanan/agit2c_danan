package com.astratech.MI2C_I.Made.Dananjaya.Adyatma_0320220067.response;

import lombok.Getter;

@Getter
public class DtoResponse {
    private int status;

    private Object data;

    private String message;

    public DtoResponse(int status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DtoResponse(int status, Object data){
        this.status = status;
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
