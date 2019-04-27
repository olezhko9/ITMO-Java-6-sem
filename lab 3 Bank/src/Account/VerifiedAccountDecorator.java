package Account;

import Client.Client;

/// SuspiciousAccount impls Account
public class VerifiedAccountDecorator extends AccountDecorator{

//    Account delegate;

    private boolean isVerifiedAccount = true;
    private double maxAmount;

    public VerifiedAccountDecorator(Account account, double maxAmount) {
        super(account);
        this.maxAmount = maxAmount;
        if (account.getAccountOwner().getAddress() == null || account.getAccountOwner().getPassportNumber() == null) {
            this.isVerifiedAccount = false;
        }
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public Client getAccountOwner() {
        return super.getAccountOwner();
    }

    @Override
    public void withdrawal(double value) {
        if (!isVerifiedAccount && value > maxAmount) {
            System.out.println("Invalid operation, verify your account.");
        } else {
            super.withdrawal(value);
        }
    }

    @Override
    public void deposit(double value) {
        super.deposit(value);
    }

    @Override
    public void transfer(Account account, double value) {
        if (!isVerifiedAccount && value > maxAmount) {
            System.out.println("Invalid operation, verify your account.");
        } else {
            super.transfer(account, value);
        }
    }
}
