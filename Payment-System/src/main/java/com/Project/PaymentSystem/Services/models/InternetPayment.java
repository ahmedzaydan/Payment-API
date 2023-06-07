package com.Project.PaymentSystem.Services.models;

import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;
import com.Project.PaymentSystem.Providers.models.InternetPaymentSP;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Vector;

public class InternetPayment implements Servic {
	 String serviceName;

	public Vector<ServiceProvider> service_providers=new Vector<>();

	public ServiceProviderFactory spf = new ServiceProviderFactory();

	@Override
	public Vector<ServiceProvider> getService_providers() {
		return service_providers;
	}
	public InternetPayment(String name)
	{
		this.serviceName = name;
		service_providers.add(new InternetPaymentSP("Orange"));
		service_providers.add(new InternetPaymentSP("We"));
		service_providers.add(new InternetPaymentSP("Etisalat"));
		service_providers.add(new InternetPaymentSP("Vodafone"));
	}
	@Override
	public String getName() {
		return serviceName;
	}

//	@Override
//	public void pay(String name,Payment payment, double cost) {
//		// TODO Auto-generated method stub
//		ServiceProvider sp=spf.selectServiceProvider(name,service_providers);
//		sp.setPayment(payment);
//		sp.pay(cost,0);
//	}
}
