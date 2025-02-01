package com.restapi.backend;

public class Account {
    private String name;
    private int number;
    private double balance;
    private String state;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }



    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }



    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}

