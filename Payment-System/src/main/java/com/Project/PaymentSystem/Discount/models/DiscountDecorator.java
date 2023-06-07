package com.Project.PaymentSystem.Discount.models;

import com.Project.PaymentSystem.Payment.models.Payment;

public class DiscountDecorator implements Payment {

    protected Payment payment;
    double discountValue;

    public DiscountDecorator(Payment payment, double disVal) {
        this.payment = payment;
        discountValue = disVal;
    }

    @Override
    public double pay(double dis) {
        // TODO Auto-generated method stub
        return payment.pay(dis + discountValue);
    }

    @Override
    public String calculateFees2(double cost, double discount) {
        return null;
    }

}