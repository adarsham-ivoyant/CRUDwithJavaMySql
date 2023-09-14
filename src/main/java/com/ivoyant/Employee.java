package com.ivoyant;

public class Employee {
    private int id;
    private String name;
    private String Address;
    private String Department;

    public Employee() {
    }

    public Employee(int id, String name, String address, String department) {
        this.id = id;
        this.name = name;
        Address = address;
        Department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
