package br.devdeloop.arthur.models.entities;

import java.util.Date;
import java.util.List;

public abstract class User {
    private String name;
    private Date birthday;
    private String id;
    private List<Test> tests;

    public User(String name, Date birthday, String id, List<Test> test) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.tests = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Test> getTest() {
        return tests;
    }

    public void setTest(List<Test> test) {
        this.tests = test;
    }
}