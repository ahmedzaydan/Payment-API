package com.Project.PaymentSystem.Payment.models;

public class Wallet implements Payment {

	double money = 0.0;

	public void setMoney(double money) {
		this.money = money;
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
			return "Payed " + discountedMoney + " With Wallet";
		} else return "Sorry, amount money entered is not enough";
	}

	public double getMoney() {
		return money;
	}
	public double addMoney(double amount) {
		money += amount;
		return amount;
	}
}