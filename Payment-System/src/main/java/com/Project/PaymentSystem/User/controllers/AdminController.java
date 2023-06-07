package com.Project.PaymentSystem.User.controllers;


import com.Project.PaymentSystem.DiscountSubject.models.OverallDiscountSubject;
import com.Project.PaymentSystem.DiscountSubject.models.SpecificDiscountSubject;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;
import com.Project.PaymentSystem.Refund.Refund;
import com.Project.PaymentSystem.Refund.RefundController;
import com.Project.PaymentSystem.Services.controllers.ServiceController;
import com.Project.PaymentSystem.Services.models.Servic;
import com.Project.PaymentSystem.User.models.Admin;
import com.Project.PaymentSystem.User.models.Client;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class AdminController {
    public Admin admin = new Admin();
    public RefundController RC = new RefundController();

    public String requestRefund(Client client, String service, double amountOfMoney) {
        Refund refund = RC.requestRefund(client, service, amountOfMoney);
        admin.addRefund(refund);
        return "Refund added successfully";
    }

    public String login(String username, String password) {
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            return "Logged in successfully";
        } else return "Invalid data";
    }

    public String signUp(String username, String password, String email) {
        if ((username.equals(admin.getUsername()) || email.equals(admin.getEmail())) && password.equals(admin.getPassword())) {
            return "Data already exist";
        } else {
            admin = new Admin(username, password, email);
            return "Signed up successfully";
        }
    }

    public String addOverallDiscount(ServiceController serviceController, double disValue) {
        OverallDiscountSubject overallDiscountSubject = new OverallDiscountSubject();
        for (Servic service : serviceController.getServices()) {
            for (ServiceProvider serviceProvider : service.service_providers) {
                overallDiscountSubject.subscribe(serviceProvider);
            }
        }
        overallDiscountSubject.setValue(disValue);
        return "Discount added successfully";
    }

    public String addSpecDiscount (ServiceController serviceController, String SPName, double disValue) {
        SpecificDiscountSubject specificDiscountSubject = new SpecificDiscountSubject();
        Vector<Servic> services = serviceController.getServices();

        for (Servic service : services) {
            for (ServiceProvider serviceProvider : service.service_providers) {
                if(serviceProvider.getName().equals(SPName))
                    specificDiscountSubject.subscribe(serviceProvider);
            }
        }
        specificDiscountSubject.setValue(disValue);
        return "Discount added successfully";
    }
    public String acceptRefund(int index) {
        if(index < admin.getSize()) {
            admin.acceptRequest(index);
            return "Refund accepted";
        }
        return "Invalid index";
    }

    public String rejectRefund(int index) {
        if(index < admin.getSize()) {
            admin.rejectRequest(index);
            return "Refund rejected";
        }
        return "Invalid index";
    }

    public Admin getAdmin() {
        return admin;
    }
}