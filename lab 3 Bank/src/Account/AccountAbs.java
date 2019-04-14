package Account;

import Client.Client;

public abstract class AccountAbs implements Account{
    protected double balance;
    protected Client accountOwner;

    public AccountAbs() {}

    public AccountAbs(Client client, double balance) {
        this.accountOwner = client;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public Client getAccountOwner() {
        return this.accountOwner;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void transfer(Account account, double value) {
        withdrawal(value);
        account.deposit(value);
    }

    public abstract void withdrawal(double value);
}
