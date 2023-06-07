package com.Project.PaymentSystem.DataFetchers;

public class PayModel {
    private String username;
    private String password;
    private String SPName;
    private String sName;
    private String paymentName;

    public PayModel(String username, String password, String SPName, String sName, String paymentName) {
        this.username = username;
        this.password = password;
        this.SPName = SPName;
        this.sName = sName;
        this.paymentName = paymentName;
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

    public String getSPName() {
        return SPName;
    }

    public void setSPName(String SPName) {
        this.SPName = SPName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
