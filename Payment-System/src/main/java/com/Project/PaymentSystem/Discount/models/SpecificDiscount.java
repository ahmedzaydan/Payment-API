package com.Project.PaymentSystem.Discount.models;

import com.Project.PaymentSystem.Payment.models.Payment;

public class SpecificDiscount extends DiscountDecorator {

    public SpecificDiscount(Payment payment, double disVal) {
        super(payment, disVal);
        // TODO Auto-generated constructor stub
    }
}
