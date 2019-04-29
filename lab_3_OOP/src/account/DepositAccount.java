package account;

import client.Client;
import java.util.Date;


public class DepositAccount extends AbstractAccount implements Account {

    private Date endDate;
    private double percent;

    public DepositAccount(Client client, double balance, Date depositDate, double percent) {
        super(client, balance);
        this.endDate = depositDate;
        this.percent = percent;
    }

    @Override
    public void withdrawal(double value) {
        if (endDate.after(new Date())) {
            System.out.println("You can't withdraw your money until deposit end date");
        } else if (this.balance < value) {
            System.out.println("Not enough money on account.");
        } else {
            this.balance -= value;
        }
    }
}
