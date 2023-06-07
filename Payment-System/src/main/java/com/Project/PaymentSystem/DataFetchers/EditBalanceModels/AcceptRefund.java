package com.Project.PaymentSystem.DataFetchers.EditBalanceModels;

public class AcceptRefund {
    private int index;
    private String username;
    private String password;

    public AcceptRefund(int index, String username, String password) {
        this.index = index;
        this.username = username;
        this.password = password;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
}
