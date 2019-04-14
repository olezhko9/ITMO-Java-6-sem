package Account;

import Client.Client;

public class SimpleAccount extends AccountAbs {

    public SimpleAccount(Client client, double balance) {
        super(client, balance);
    }

    @Override
    public void withdrawal(double value) {
        if (this.balance < value) {
            System.out.println("Not enough money on account.");
        } else {
            this.balance -= value;
        }
    }
}
