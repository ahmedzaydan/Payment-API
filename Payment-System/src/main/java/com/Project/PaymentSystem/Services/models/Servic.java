package com.Project.PaymentSystem.Services.models;

import com.Project.PaymentSystem.Providers.models.ServiceProvider;
import com.Project.PaymentSystem.Providers.controllers.ServiceProviderFactory;

import java.util.Vector;

public interface Servic {
	public Vector<ServiceProvider> service_providers=new Vector<>();
	 String serviceName = null;
	 public String getName();

	public ServiceProviderFactory spf = null;
//	public void pay(String name, Payment payment, double cost);
	public Vector<ServiceProvider> getService_providers();
}
