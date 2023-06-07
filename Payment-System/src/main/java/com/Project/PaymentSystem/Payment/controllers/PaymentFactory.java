package com.Project.PaymentSystem.Payment.controllers;

import com.Project.PaymentSystem.Payment.models.Cash;
import com.Project.PaymentSystem.Payment.models.CreditCard;
import com.Project.PaymentSystem.Payment.models.Payment;
import com.Project.PaymentSystem.Payment.models.Wallet;
import com.Project.PaymentSystem.User.models.Client;

public class PaymentFactory {
	public Payment getPayment(String name, Client client) {
		return switch (name) {
			case "Cash" -> client.getCash();
			case "Wallet" -> client.getWallet();
			case "Credit Card" -> client.getCreditCard();
			default -> null;
		};
	}
}