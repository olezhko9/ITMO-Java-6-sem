package Account;

public abstract class AccountAbs implements Account{
    double balance;

    public Double getBalance() {
        return this.balance;
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
