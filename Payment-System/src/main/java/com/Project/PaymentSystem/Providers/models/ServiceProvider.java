package com.Project.PaymentSystem.Providers.models;

import com.Project.PaymentSystem.Payment.models.Payment;

public interface ServiceProvider {
    Payment payment = null;
    Payment temp = null;
    String name = null;
    public boolean hasDiscount = false;

    public boolean getHasDiscount();

    public void setName(String name);

    public String getName();

    public double pay(double discount);

    public String calculateFees(Payment payment);
}