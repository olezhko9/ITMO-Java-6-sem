package Account;

public interface Account {
    void withdrawal(double value);
    void deposit(double value);
    void transfer(Account account, double value);
}
