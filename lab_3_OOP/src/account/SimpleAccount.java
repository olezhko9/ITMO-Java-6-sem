package account;

import client.Client;


public class SimpleAccount extends AbstractAccount implements Account {

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
