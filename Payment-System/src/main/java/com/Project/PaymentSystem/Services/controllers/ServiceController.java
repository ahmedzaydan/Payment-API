package com.Project.PaymentSystem.Services.controllers;

import com.Project.PaymentSystem.Payment.controllers.PaymentFactory;
import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;
import com.Project.PaymentSystem.Services.models.*;
import com.Project.PaymentSystem.User.controllers.AdminController;
import com.Project.PaymentSystem.User.models.Client;

import java.util.Vector;

public class ServiceController {
     Vector<Servic> services = new Vector<>();
    ServiceProviderFactory spf = new ServiceProviderFactory();

    PaymentFactory paymentFactory = new PaymentFactory();

    public ServiceController() {
        services.add(new InternetPayment("Internet Payment"));
        services.add(new Donation("Donation"));
        services.add(new Landline("Landline"));
        services.add(new MobileRecharge("Mobile Recharge"));
    }

    public String pay(Client client, String paymentMethod, String sName, String SPName, AdminController adminController) {
        for (Servic service : services) {
            if ((service.getName()).equalsIgnoreCase(sName)) {
                ServiceProvider sp = spf.selectServiceProvider(SPName, service.getService_providers());
                if (sp == null)
                    return SPName + " dose not provide " + sName;
                else {
                    adminController.getAdmin().getPaymentsTransactions().add(paymentFactory.getPayment(paymentMethod, client));
                    return SPName + " Service Provider: " + sp.calculateFees(paymentFactory.getPayment(paymentMethod, client));
                }
            }
        }
        return sName + " dose not exist";

    }

    public String searchDiscount(String SPName) {
        for (Servic service : services) {
            for (ServiceProvider serviceProvider : service.service_providers) {
                if (serviceProvider.getName().equals(SPName)) {
                    if (serviceProvider.getHasDiscount()) return serviceProvider.getName() + " has discount";
                    else return SPName + " has no discount";
                }
            }
        }
        return SPName + " is not valid service provider name";
    }

    public String searchService(String name) {
        for (Servic service : services) {
            if (service.getName().equals(name))
                return name;
        }
        return "Not found";
    }

    public Vector<Servic> getServices() {
        return this.services;
    }
}
