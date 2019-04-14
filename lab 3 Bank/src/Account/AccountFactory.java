package Account;

import Client.Client;
import java.util.Date;

public class AccountFactory {

    public AccountAbs newSimpleAccount(Client client, double balance) {
        return new SimpleAccount(client, balance);
    }

    public AccountAbs newDepostAccount(Client client, double balance, Date depositDate, double percent) {
        return new DepositAccount(client, balance, depositDate, percent);
    }

    public AccountAbs newCreditAccount(Client client, double balance, double commission, double limit) {
        return new CreditAccount(client, balance, commission, limit);
    }
}
