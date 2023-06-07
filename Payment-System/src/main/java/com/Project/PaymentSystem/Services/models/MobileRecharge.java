package com.Project.PaymentSystem.Services.models;

import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;
import com.Project.PaymentSystem.Providers.models.MobileRechargeSP;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Vector;

public class MobileRecharge implements Servic {
    public Vector<ServiceProvider> service_providers = new Vector<>();

    @Override
    public Vector<ServiceProvider> getService_providers() {
        return service_providers;
    }

    String serviceName;

    public MobileRecharge(String name) {
        this.serviceName = name;
        service_providers.add(new MobileRechargeSP("Orange"));
        service_providers.add(new MobileRechargeSP("We"));
        service_providers.add(new MobileRechargeSP("Etisalat"));
        service_providers.add(new MobileRechargeSP("Vodafone"));
    }

    public ServiceProviderFactory spf = new ServiceProviderFactory();

    @Override
    public String getName() {
        return serviceName;
    }

//    @Override
//    public void pay(String name, Payment payment, double cost) {
//        // TODO Auto-generated method stub
//        ServiceProvider sp = spf.selectServiceProvider(name, service_providers);
//        sp.setPayment(payment);
//        sp.pay(cost, 0);
//    }
}
