package com.Project.PaymentSystem.User.models;


import com.Project.PaymentSystem.Payment.models.Cash;
import com.Project.PaymentSystem.Payment.models.CreditCard;
import com.Project.PaymentSystem.Payment.models.Wallet;

public class Client extends User {
    public Client(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    Wallet wallet = new Wallet();
    CreditCard creditCard = new CreditCard();
    Cash cash = new Cash();

    public void addToWallet(double money) {
        this.wallet.setMoney(money);
    }

    public void addToCreditCard(double money) {
        this.creditCard.setMoney(money);
    }

    public void addToCash(double money) {
        this.cash.setMoney(money);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Cash getCash() {
        return cash;
    }

    public String  addFundToWallet(double amount) {

        return wallet.addMoney(creditCard.takeMoney(amount)) + "  money added successfully";
    }
}
