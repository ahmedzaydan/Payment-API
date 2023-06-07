package com.Project.PaymentSystem.DiscountSubject.models;

import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.LinkedList;
import java.util.List;

public interface Subject {
	public List<ServiceProvider> observers = new LinkedList<>();

	public void subscribe(ServiceProvider sp);

	public void unsubscribe(ServiceProvider sp);

	public void myNotify();
}