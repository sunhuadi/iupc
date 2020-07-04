package com.iupc.pojo;

public class Record {
    private String username;
    private String record_keys;
    private int times;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return record_keys;
    }

    public void setKey(String key) {
        this.record_keys = key;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
