package com.usermanagement.domain.entities;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class User {
    public UUID Id;
    public String FirstName ;
    public String LastName;
    public String Email ;
    public String Password;
    public double Salary;
    public double Point;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Salary= '" + Salary  +'\''+
                ", Point= '" + Point  +'\''+
                '}';
    }
    public String getFullName(){
        return this.FirstName + " " + this.LastName;
    }
}
