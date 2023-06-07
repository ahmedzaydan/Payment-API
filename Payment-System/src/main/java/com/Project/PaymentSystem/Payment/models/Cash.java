package com.Project.PaymentSystem.Payment.models;

public class Cash implements Payment {
    double money = 0;

    public Cash() {
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
            return "Payed " + discountedMoney + " With Cash";
        } else return "Sorry, amount money entered is not enough";
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double amount) {
        money += amount;
    }

    public String setMoney(double money) {
        this.money += money;
        return "Your new cash balance is: " + this.money;
    }

}