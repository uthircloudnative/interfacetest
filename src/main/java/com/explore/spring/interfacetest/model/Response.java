package com.explore.spring.interfacetest.model;

import java.util.Objects;

public class Response {

    private String msg;

    public Response() {
    }

    public Response(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        Response response = (Response) o;
        return Objects.equals(msg, response.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
