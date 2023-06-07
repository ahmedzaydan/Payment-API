package com.Project.PaymentSystem.Services.models;

import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;
import com.Project.PaymentSystem.Providers.models.LandlineSP;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Vector;

public class Landline implements Servic {
	public String serviceName;

	public Vector<ServiceProvider> service_providers=new Vector<>();

	public ServiceProviderFactory spf = new ServiceProviderFactory();
	@Override
	public Vector<ServiceProvider> getService_providers() {
		return service_providers;
	}

	public Landline(String name)
	{
		this.serviceName = name;
		service_providers.add(new LandlineSP("MonthlyReceipt"));
		service_providers.add(new LandlineSP("QuarterReceipt"));
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
