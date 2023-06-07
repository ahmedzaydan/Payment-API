package com.Project.PaymentSystem.Discount.models;

import com.Project.PaymentSystem.Payment.models.Payment;

public class OverallDiscount extends DiscountDecorator {

	public OverallDiscount(Payment payment, double disValue) {
		super(payment, disValue);
		// TODO Auto-generated constructor stub
	}



}
