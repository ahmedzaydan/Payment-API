package com.Project.PaymentSystem.Payment.models;

public class CreditCard implements Payment {
    double money = 0.0;

    public double getMoney() {
        return money;
    }

    public void addMoney(double amount) {
        money += amount;
    }

    public double takeMoney(double amount) {
        if (amount <= money) {
            money -= amount;
            return amount;
        } else return 0.0;
    }

    public String setMoney(double money) {
        this.money += money;
        return "Your new credit card balance is: " + this.money;
    }
    @Override
    public double pay(double dis) {
        // TODO Auto-generated method stub
        return dis;
    }

    @Override
    public String calculateFees2(double cost, double dis) {
        double discountedMoney = cost - (cost * (dis / 100));
        if (money >= discountedMoney) {
            money -= discountedMoney;
            return "Payed " + discountedMoney + " With Credit Card";
        } else return "Sorry, amount money entered is not enough";
    }

}