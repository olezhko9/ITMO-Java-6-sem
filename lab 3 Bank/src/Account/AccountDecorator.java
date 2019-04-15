package Account;

import Client.Client;

public class AccountDecorator implements Account {

    private Account account;

    public AccountDecorator(Account account) {
        this.account = account;
    }

    @Override
    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public Client getAccountOwner() {
        return this.account.getAccountOwner();
    }

    @Override
    public void withdrawal(double value) {
        this.account.withdrawal(value);
    }

    @Override
    public void deposit(double value) {
        this.account.deposit(value);
    }

    @Override
    public void transfer(Account account, double value) {
        this.account.transfer(account, value);
    }
}
