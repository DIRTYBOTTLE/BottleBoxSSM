package com.bottle.domain;

public class Document {
    private Integer id;
    private String name;
    private String uuid;
    private String time;
    private Integer userId;

    public Document() {
    }

    public Document(Integer id, String name, String uuid, String time, Integer userId) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.time = time;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
