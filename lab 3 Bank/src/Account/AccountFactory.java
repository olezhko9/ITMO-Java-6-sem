package Account;

public class AccountFactory {

    public AccountAbs newSimpleAccount() {
        return new SimpleAccount();
    }

    public AccountAbs newDepostAccount() {
        return new DepositAccount();
    }

    public AccountAbs newCreditAccount() {
        return new CreditAccount();
    }
}
