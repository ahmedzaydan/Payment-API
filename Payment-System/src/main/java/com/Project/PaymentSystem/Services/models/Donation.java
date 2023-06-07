package com.Project.PaymentSystem.Services.models;

import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;
import com.Project.PaymentSystem.Providers.models.DonationSP;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Vector;


public class Donation implements Servic {
	 String serviceName;
	 public Vector<ServiceProvider> service_providers=new Vector<>();

	 ServiceProviderFactory spf = new ServiceProviderFactory();


	 public Donation(String name)
	 {
		 this.serviceName = name;

		 service_providers.add(new DonationSP("School"));
		 service_providers.add(new DonationSP("CancerHospital"));
		 service_providers.add(new DonationSP("NGOs"));
	 }
	@Override
	public String getName() {
		return serviceName;
	}

//	@Override
//	public void pay(String name, Payment payment, double cost) {
//		// TODO Auto-generated method stub
//		ServiceProvider sp=spf.selectServiceProvider(name,service_providers);
//		sp.setPayment(payment);
//		sp.pay(cost,0);
//	}

	@Override
	public Vector<ServiceProvider> getService_providers() {
		return service_providers;
	}
}
