package com.Project.PaymentSystem.Providers.controllers;

import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Vector;

public class ServiceProviderFactory {
	public ServiceProviderFactory() {
		
	}
	public ServiceProvider selectServiceProvider(String name , Vector<ServiceProvider> serviceProviders) {
		for (ServiceProvider serviceProvider : serviceProviders) {
			if (serviceProvider.getName().equalsIgnoreCase(name)) {
				return serviceProvider;
			}
		}
		return null;
	}
}
