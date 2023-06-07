package com.Project.PaymentSystem.Providers.models;

import com.Project.PaymentSystem.Discount.models.OverallDiscount;
import com.Project.PaymentSystem.Discount.models.SpecificDiscount;
import com.Project.PaymentSystem.Payment.models.CreditCard;
import com.Project.PaymentSystem.Payment.models.Payment;

public class DonationSP implements ServiceProvider, Observer {
    Payment payment = new CreditCard();
    Payment temp = payment;
    String name;
    boolean hasDiscount = false;
    double cost = 50.0;
    double disValue = 0.0;

    public DonationSP(String name) {
        this.name = name;
    }

    @Override
    public void update(double val, String type) {
        disValue += val;
        hasDiscount = true;
    }

    @Override
    public boolean getHasDiscount() {
        return hasDiscount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double pay(double discount) {
        return payment.pay(discount);
    }

    @Override
    public String calculateFees(Payment payment) {
        temp = payment;
        return temp.calculateFees2(this.cost, disValue);
    }
}
