package com.Project.PaymentSystem.Refund;


import com.Project.PaymentSystem.User.models.Client;

public class Refund {
    Client client=null;
    String service;
    double amountOfMoney;
    public void setData(Client client,String service,double amountOfMoney)
    {
        this.client=client;
        this.service=service;
        this.amountOfMoney=amountOfMoney;
    }

    public Client getClient() {
        return client;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public String getService() {
        return service;
    }
}
