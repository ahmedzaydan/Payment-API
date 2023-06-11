# Payment API

Welcome to the Payment API project! This software project aims to develop a system similar to Fawry, which enables users to make payments for various services. The payment services included in this project are:

## Services
1. **Mobile Recharge Services**: Users can recharge their mobile phone accounts using the following service providers:
   - Vodafone
   - Etisalat
   - Orange
   - We

2. **Internet Payment Services**: Users can make internet bill payments through the system for the following service providers:
   - Vodafone
   - Etisalat
   - Orange
   - We

3. **Landline Services**: Users can pay for landline services, including:
   - Monthly receipt
   - Quarterly receipt

4. **Donations**: Users have the option to make donations to the following organizations:
   - Cancer Hospital
   - Schools
   - NGOs (Non-profit organizations)

## API provides the follwing web services:
### 1. The system checks if the username or the email is registered before.

   Endpoint: GET /user/check

   Description: A service to check if the user exists or not. This service returns all user info if exists

   Input: email and password.
 
### 2. The user can sign in to the system.

   Endpoint: POST/Client/login

   Input: username, password

### 3. The user can sign up to the system

   Endpoint: POST/Client/signup

   Input: username, password and email

### 4. The admin can sign in to the system.

   Endpoint: POST/Admin/login

   Input: username, password

### 5. The admin can sign up to the system.

   Endpoint: POST/Admin/signup

   Input: username, password and email 

### 6. The user can search for any service in the system.

   Endpoint: POST /Client/search/service

   Input: service name

### 7. The user can pay for any service in the system.

   Endpoint: POST/Client/pay

### 8. The user can ask for a refund for any complete transaction to any given service.

   Endpoint: POST/Client/refund

### 9. The system maintain a wallet balance for each user

   Endpoint: PUT /Client/wallet

### 10. The user can check any discount for any service in the system.

   Endpoint: POST /Client/search/discount

### 11. The system allow the admin to add overall discounts. (for all products)

   Endpoint: POST /Admin/adddiscount/overall

### 12. The system allow the admin to add specific discounts. (for specific products)

   Endpoint: POST /Admin/adddiscount/ specific

### 13. The admin can accept or reject any refund request.

Endpoint: POST /Admin/refund/accept

Input : refund id

## Getting Started
To get started with the Payment API project, follow these steps:

1. Clone the repository to your local machine.
2. Install the necessary dependencies, if any.
3. Open IDE
4. Run the project.
5. Open Postman
6. Import Collection URL: 
https://elements.getpostman.com/redirect?entityId=23538524-276203b9-112c-41c2-b1f8-14bc40a2d0af&entityType=collection
7. Choose any functionality you want

Note: Admin functions need admin authorization admin wants to do, he should sign in before
Note: this project depends on java 17

## Contributing
Contributions to the Payment API project are welcome! If you'd like to contribute, please follow these guidelines:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Commit your changes and push them to your forked repository.
3. Submit a pull request, explaining the purpose and details of your contribution.

## Contact
If you have any questions or suggestions regarding the Payment API project, please feel free to contact us at: [ahmedzidanesyrian@gmail.com](mailto:ahmedzidanesyrian@gmail.com), 
[abdallahgomaa1000@gmail.com](mailto:abdallahgomaa1000@gmail.com)
