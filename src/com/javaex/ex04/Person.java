package com.javaex.ex04;

public class Person {
    private String name,mobile,company;

    public Person() {
    }

    public Person(String name, String mobile, String company) {
        this.name = name;
        this.mobile = mobile;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void showInfo() {
        System.out.println("이름: "+this.name);
        System.out.println("핸드폰: "+this.mobile);
        System.out.println("회사: "+this.company);
        System.out.println();
    }

    @Override
    public String toString() {
        return this.name+","+this.mobile+","+this.company+"\n";
    }
}
