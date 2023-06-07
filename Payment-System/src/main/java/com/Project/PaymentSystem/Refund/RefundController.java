package com.Project.PaymentSystem.Refund;


import com.Project.PaymentSystem.User.models.Client;

public class RefundController {
    public Refund requestRefund(Client client, String service, double amountOfMoney)
    {
        Refund refund=new Refund();
        refund.setData(client,service,amountOfMoney);
        return refund;
    }
}
