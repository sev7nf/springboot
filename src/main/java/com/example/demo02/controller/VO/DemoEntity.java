package com.example.demo02.controller.VO;

public class DemoEntity {
    private String dataId;
    private String name;
    private int age;

    public DemoEntity() {
    }

    public DemoEntity(String dataId) {
        this.dataId = dataId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "dataId='" + dataId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
