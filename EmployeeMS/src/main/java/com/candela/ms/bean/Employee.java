package com.candela.ms.bean;

public class Employee {

    private String id;
    private String name;
    private String position;
    private boolean operation;

    public Employee()
    {}

    public Employee( String name, String post)
    {
        this.name = name;
        this.position = post;
    }

    public Employee( String id , String name, String post)
    {
        this.id = id;
        this.name = name;
        this.position = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s ", id, name, position);
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }
}
