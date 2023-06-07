package com.Project.PaymentSystem.User.models;

import java.util.Vector;

public class ClientData {
    public Vector<Client> clients = new Vector<>();

    public String addClient(Client client) {
        clients.add(client);
        return "added successfully";
    }

    public ClientData() {
    }

    public Client search(String username, String password, String email) {
        for (Client client : clients) {
            if (client.getPassword().equals(password) && (client.getUsername().equals(username) || client.getEmail().equals(email)))
                return client;
        }
        return null;
    }

    public Client login(String username, String password) {
        return search(username, password, null);
    }

    public Client signUp(String username, String password, String email) {
        Client client = search(username, password, email);
        if (client == null)
            addClient(new Client(username, password, email));
        return client;
    }
}
