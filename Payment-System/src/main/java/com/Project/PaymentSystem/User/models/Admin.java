package com.Project.PaymentSystem.User.models;


import com.Project.PaymentSystem.Payment.models.Payment;
import com.Project.PaymentSystem.Payment.models.Wallet;
import com.Project.PaymentSystem.Refund.Refund;

import java.util.Vector;

public class Admin extends User {
    Vector<Refund> refunds = new Vector<>();
    Vector<Refund> refundsTransactions = new Vector<>();
    Vector<Payment> paymentsTransactions = new Vector<>();
    Vector<Wallet> addToWalletTransactions = new Vector<>();

    public Vector<Refund> getRefundsTransactions() {
        return refundsTransactions;
    }

    public Vector<Payment> getPaymentsTransactions() {
        return paymentsTransactions;
    }

    public Vector<Wallet> getAddToWalletTransactions() {
        return addToWalletTransactions;
    }

    public int getSize() {
        return refunds.size();
    }

    public Admin(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Admin() {
    }

    public void addRefund(Refund refund) {
        refunds.add(refund);
    }

    public Vector<Refund> getRefunds() {
        return refunds;
    }

    public void acceptRequest(int idx) {
        Refund refund = refunds.get(idx);
        Client client = refund.getClient();
        Wallet wallet = client.getWallet();
        wallet.addMoney(refund.getAmountOfMoney());
        refundsTransactions.add(refunds.get(idx));
        refunds.removeElementAt(idx);
    }

    public void rejectRequest(int idx) {
        refunds.removeElementAt(idx);
    }
}
