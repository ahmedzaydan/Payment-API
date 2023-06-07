package com.Project.PaymentSystem.DataFetchers;

public class RefundModel {
    private String username;
    private String password;
    private String serviceName;
    private double amountOfMoney;

    public RefundModel(String username, String password, String serviceName, double amountOfMoney) {
        this.username = username;
        this.password = password;
        this.serviceName = serviceName;
        this.amountOfMoney = amountOfMoney;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
