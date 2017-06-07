package com.jy.designpattern.entity;

/**
 * 汽车类
 * */
public class Car {

    /**
     * 车头
     * */
    private String head;

    /**
     * 车身
     * */
    private String body;
    /**
     * 车尾
     * */
    private String tail;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Car{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", tail='" + tail + '\'' +
                '}';
    }
}
