package com.Project.PaymentSystem.User.controllers;

import com.Project.PaymentSystem.User.models.Client;
import com.Project.PaymentSystem.User.models.ClientData;
import org.springframework.stereotype.Service;

@Service
public class ClientController {
    public ClientData clientData = new ClientData();

    public String login(String username, String password) {
        if (clientData.login(username, password) == null) return "Invalid username and password";
        else return "Logged in successfully";
    }
    public String signUp(String username, String password, String email) {
        if (clientData.signUp(username, password, email) == null) return "Signed up successfully";
        else return "Username and password are already exist";
    }

    public Client checkClient(String username, String password) {
        return clientData.login(username, password);

    }
}