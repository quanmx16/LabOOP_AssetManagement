package com.bmlt.emplyee;

import java.time.LocalDate;

public class Employee {

    //employID name birthdate role sex password
    private String employID;
    private String name;
    private LocalDate birthDate;
    private String role;
    private String sex;
    private String password;

    public Employee(String employID, String name, LocalDate birthDate, String role, String sex, String password) {
        this.employID = employID;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public Employee() {
    }

    public String getEmployID() {
        return employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //employID name birthdate role sex password
    @Override
    public String toString() {
        return getEmployID() + "|" + getName() + "|" + getBirthDate().toString() + "|" + getRole() + "|" + getSex() + "|" + getPassword();
    }

}
