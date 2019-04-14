package Account;

import Client.Client;

public interface Account {
    void withdrawal(double value);
    void deposit(double value);
    void transfer(Account account, double value);

    double getBalance();
    Client getAccountOwner();
}
