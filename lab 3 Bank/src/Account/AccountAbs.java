package Account;

import Client.Client;

public abstract class AccountAbs implements Account{
    private double balance;
    private Client accountOwner;

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
