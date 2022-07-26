package com.study.rpc.serialize;

/**
 * @author zhaopc
 * @date 2021/7/19 19:43
 */
public class Student {

    private String username;
    private Long t;
    private String sex;

    public Student(String username, String sex, Long t) {
        this.username = username;
        this.sex = sex;
        this.t = t;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", t=" + t +
                '}';
    }
}
