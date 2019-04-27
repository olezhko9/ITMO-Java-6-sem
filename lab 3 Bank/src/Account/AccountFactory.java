package Account;

import Client.Client;

import java.util.Date;

public class AccountFactory {

    private double creditCommission;
    private double depositPercent;

    public AccountFactory(double creditCommission, double depositPercent) {
        this.creditCommission = creditCommission;
        this.depositPercent = depositPercent;
    }

    public AccountAbs newSimpleAccount(Client client, double balance) {
        return new SimpleAccount(client, balance);
    }

    public AccountAbs newDepositAccount(Client client, double balance, Date depositDate) {
        return new DepositAccount(client, balance, depositDate, this.depositPercent);
    }

    public AccountAbs newCreditAccount(Client client, double balance, double limit) {
        return new CreditAccount(client, balance, limit, this.creditCommission);
    }
}
