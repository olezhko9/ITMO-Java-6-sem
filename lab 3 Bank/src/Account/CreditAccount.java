package Account;

import Client.Client;

public class CreditAccount extends AccountAbs {

    private double limit;
    private double commission;

    public CreditAccount(Client client, double balance, double commission, double limit) {
        super(client, balance);
        this.limit = limit * -1;
        this.commission = commission;
    }

    @Override
    public void withdrawal(double value) {
        if (this.balance - value < limit) {
            System.out.println("Credit limit exceeded.");
        } else {
            this.balance -= value;
            if (this.balance < 0)
                this.balance -= commission;
        }
    }
}
