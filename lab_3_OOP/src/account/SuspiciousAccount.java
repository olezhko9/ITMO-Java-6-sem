package account;

import client.Client;


public class SuspiciousAccount implements Account {

    private Account delegateAccount;

    private double maxAmount;

    SuspiciousAccount(Account account, double maxAmount) {
        this.delegateAccount = account;
        this.maxAmount = maxAmount;
    }

    public double getBalance() {
        return delegateAccount.getBalance();
    }

    public Client getAccountOwner() {
        return delegateAccount.getAccountOwner();
    }

    @Override
    public void withdrawal(double value) {
        if (value > this.maxAmount) {
            System.out.println("Invalid operation, verify your account.");
        } else if (delegateAccount.getBalance() < value) {
            System.out.println("Not enough money on account.");
        } else {
            delegateAccount.withdrawal(value);
            System.out.println("Withdrawing success.");
        }
    }

    @Override
    public void deposit(double value) {
        delegateAccount.deposit(value);
    }

    @Override
    public void transfer(Account account, double value) {
        if (value > maxAmount) {
            System.out.println("Invalid operation, verify your account.");
        } else {
            delegateAccount.transfer(account, value);
            System.out.println("Transfer success.");
        }
    }
}
