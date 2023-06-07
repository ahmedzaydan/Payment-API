package com.Project.PaymentSystem.Payment.models;

public  interface Payment {
	Payment payment = null;
	public double pay(double dis);

	String calculateFees2(double cost, double discount);
}
