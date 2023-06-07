package com.Project.PaymentSystem.DataFetchers;

public class SpecDiscountModel {
    private String username;
    private String password;
    private double money;
    private String SPName;

    public SpecDiscountModel(String username, String password, double money, String SPName) {
        this.username = username;
        this.password = password;
        this.money = money;
        this.SPName = SPName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getSPName() {
        return SPName;
    }

    public void setSPName(String SPName) {
        this.SPName = SPName;
    }
}
