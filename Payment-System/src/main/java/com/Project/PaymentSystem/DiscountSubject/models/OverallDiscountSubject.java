package com.Project.PaymentSystem.DiscountSubject.models;

import com.Project.PaymentSystem.Providers.models.Observer;
import com.Project.PaymentSystem.Providers.models.ServiceProvider;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OverallDiscountSubject implements Subject {
	public List<ServiceProvider> observers = new LinkedList<>();
	double discountValue = 0.0;
	

	@Override
	public void subscribe(ServiceProvider sp) {
		// TODO Auto-generated method stub
		observers.add(sp);
	}

	@Override
	public void unsubscribe(ServiceProvider sp) {
		// TODO Auto-generated method stub
		observers.remove(sp);
	}

	@Override
	public void myNotify() {
		// TODO Auto-generated method stub
		for (Iterator<ServiceProvider> iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(discountValue,"Overall");
		}
	}

	public void setValue(double val) {
		discountValue = val;
		this.myNotify();
	}
}
