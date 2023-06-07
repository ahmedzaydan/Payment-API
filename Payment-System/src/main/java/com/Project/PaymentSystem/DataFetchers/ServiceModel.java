package com.Project.PaymentSystem.DataFetchers;

public class ServiceModel {
    public String serviceName;

    public ServiceModel(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
