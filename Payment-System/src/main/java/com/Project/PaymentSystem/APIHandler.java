package com.Project.PaymentSystem;

import com.Project.PaymentSystem.DataFetchers.EditBalanceModels.AcceptRefund;
import com.Project.PaymentSystem.DataFetchers.EditBalanceModels.BalanceModel;
import com.Project.PaymentSystem.DataFetchers.PayModel;
import com.Project.PaymentSystem.DataFetchers.RefundModel;
import com.Project.PaymentSystem.DataFetchers.SpecDiscountModel;
import com.Project.PaymentSystem.Payment.models.Payment;
import com.Project.PaymentSystem.Payment.models.Wallet;
import com.Project.PaymentSystem.Refund.Refund;
import com.Project.PaymentSystem.Services.controllers.ServiceController;
import com.Project.PaymentSystem.User.controllers.AdminController;
import com.Project.PaymentSystem.User.controllers.ClientController;
import com.Project.PaymentSystem.User.models.Admin;
import com.Project.PaymentSystem.User.models.Client;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController
public class APIHandler {
    private ClientController clientController = new ClientController();
    private AdminController adminController = new AdminController();

    private final ServiceController serviceController = new ServiceController();

    public APIHandler(AdminController adminController) {
        this.adminController = adminController;
    }

    public APIHandler(ClientController clientController) {
        this.clientController = clientController;
    }


    public APIHandler() {
    }

    // signup functionality for client
    @PostMapping("/Client/signup")
    public String signUp(@RequestBody Client client) {
        return clientController.signUp(client.getUsername(), client.getPassword(), client.getEmail());
    }

    // login functionality for client
    @PostMapping("/Client/login")
    public String login(@RequestBody Client client) {
        return clientController.login(client.getUsername(), client.getPassword());
    }

    // signup functionality for admin
    @PostMapping("/Admin/signup")
    public String signUp(@RequestBody Admin admin) {
        return adminController.signUp(admin.getUsername(), admin.getPassword(), admin.getEmail());
    }

    // login functionality for admin
    @PostMapping("/Admin/login")
    public String login(@RequestBody Admin admin) {
        return adminController.login(admin.getUsername(), admin.getPassword());
    }


    // search for serivce functionality
    @PostMapping("/Client/search/service")
    public String searchService(@RequestBody String serviceName) {
        return serviceController.searchService(serviceName);
    }

    // search for discount functionality
    @PostMapping("/Client/search/discount")
    public String searchDiscount(@RequestBody String serviceName) {
        return serviceController.searchDiscount(serviceName);
    }

    // pay for any service functionality
    @PostMapping("/Client/pay")
    public String pay(@RequestBody PayModel payModel) {
        Client client = clientController.checkClient(payModel.getUsername(), payModel.getPassword());
        return serviceController.pay(client, payModel.getPaymentName(), payModel.getsName(), payModel.getSPName(), adminController);
    }

    // edit cash balance
    @PutMapping("/Client/cash")
    public String updateCash(@RequestBody BalanceModel balanceModel) {
        Client client = clientController.checkClient(balanceModel.getUsername(), balanceModel.getPassword());
        if (client == null) return "Invalid data";
        return client.getCash().setMoney(balanceModel.getMoney());
    }

    // edit credit card functionality
    @PutMapping("/Client/creditcard")
    public String updateCreditCard(@RequestBody BalanceModel balanceModel) {
        Client client = clientController.checkClient(balanceModel.getUsername(), balanceModel.getPassword());
        if (client == null) return "Invalid data";
        else return client.getCreditCard().setMoney(balanceModel.getMoney());
    }

    // ask for refund
    @PostMapping("/Client/refund")
    public String askForRefund(@RequestBody RefundModel refundModel) {
        Client client = clientController.checkClient(refundModel.getUsername(), refundModel.getPassword());
        if (client == null) return "Invalid data";
        return adminController.requestRefund(client, refundModel.getServiceName(), refundModel.getAmountOfMoney());
    }

    // add fund to wallet
    @PutMapping("/Client/wallet")
    public String updateWallet(@RequestBody BalanceModel balanceModel) {
        Client client = clientController.checkClient(balanceModel.getUsername(), balanceModel.getPassword());
        if (client == null) return "Invalid data";
        adminController.getAdmin().getAddToWalletTransactions().add(client.getWallet());
        return client.addFundToWallet(balanceModel.getMoney());
    }

    // add overall discount functionality
    @PostMapping("/Admin/adddiscount/overall")
    public String addOverall(@RequestBody BalanceModel balanceModel) {
        if ((adminController.login(balanceModel.getUsername(), balanceModel.getPassword())).equals("Logged in successfully")) {
            return adminController.addOverallDiscount(serviceController, balanceModel.getMoney());
        } else return "Invalid data";
    }

    // add specific discount functionality
    @PostMapping("/Admin/adddiscount/specific")
    public String addSpecific(@RequestBody SpecDiscountModel specDiscountModel) {
        if ((adminController.login(specDiscountModel.getUsername(), specDiscountModel.getPassword())).equals("Logged in successfully")) {
            return adminController.addSpecDiscount(serviceController, specDiscountModel.getSPName(), specDiscountModel.getMoney());
        } else return "Invalid data";
    }

    // accept refund functionality
    @PostMapping("/Admin/refund/accept")
    public String acceptRefund(@RequestBody AcceptRefund acceptRefund) {
        if ((adminController.login(acceptRefund.getUsername(), acceptRefund.getPassword())).equals("Logged in successfully")) {
            return adminController.acceptRefund(acceptRefund.getIndex());
        } else return "Invalid data";
    }

    // reject refund functionality
    @PostMapping("/Admin/refund/reject")
    public String rejectRefund(@RequestBody AcceptRefund acceptRefund) {
        if ((adminController.login(acceptRefund.getUsername(), acceptRefund.getPassword())).equals("Logged in successfully")) {
            return adminController.acceptRefund(acceptRefund.getIndex());
        } else return "Invalid data";
    }

    @GetMapping("/Admin/list/refunds")
    public Vector<Response<Refund>> listRefunds() {
        Vector<Response<Refund>> refunds = new Vector<>();
        for (int i = 0; i < adminController.getAdmin().getSize(); i++) {
            Response<Refund> refund = new Response<Refund>();
            refund.object = adminController.getAdmin().getRefunds().get(i);
            refund.setMessage("refund " + (i + 1));
            refund.setStatus(true);
            refunds.add(refund);
        }
        return refunds;
    }

    // list all transactions refunds
    @GetMapping("/Admin/transactions/refunds")
    public Vector<Response<Refund>> transactionsRefunds() {
        Vector<Response<Refund>> transactionRefunds = new Vector<>();
        for (int i = 0; i < adminController.getAdmin().getRefundsTransactions().size(); i++) {
            Response<Refund> refund = new Response<Refund>();
            refund.object = adminController.getAdmin().getRefundsTransactions().get(i);
            refund.setMessage("refund " + (i + 1));
            refund.setStatus(true);
            transactionRefunds.add(refund);
        }
        return transactionRefunds;
    }

    // list payment transactions
    @GetMapping("/Admin/transactions/payment")
    public Vector<Response<Payment>> paymentTransactions() {
        Vector<Response<Payment>> paymentTransactions = new Vector<>();
        for (int i = 0; i < adminController.getAdmin().getPaymentsTransactions().size(); i++) {
            Response<Payment> refund = new Response<>();
            refund.object = adminController.getAdmin().getPaymentsTransactions().get(i);
            refund.setMessage("refund " + (i + 1));
            refund.setStatus(true);
            paymentTransactions.add(refund);
        }
        return paymentTransactions;
    }
    // list wallet transactions
    @GetMapping("/Admin/transactions/wallet")
    public Vector<Response<Wallet>>getWalletTransactions() {
        Vector<Response<Wallet>> walletTransactions = new Vector<>();
        for (int i = 0; i < adminController.getAdmin().getAddToWalletTransactions().size(); i++) {
            Response<Wallet> refund = new Response<>();
            refund.object = adminController.getAdmin().getAddToWalletTransactions().get(i);
            refund.setMessage("refund " + (i + 1));
            refund.setStatus(true);
            walletTransactions.add(refund);
        }
        return walletTransactions;
    }
}