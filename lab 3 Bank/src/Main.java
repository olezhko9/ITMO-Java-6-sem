import Account.*;
import Client.Client;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Client bankClient = Client.newClient()
                .setFirstName("Oleg")
                .setSecondName("Naumov")
                .setAddress("Moscow")
                .setPassportNumber("999999")
                .build();

        System.out.println(bankClient.getFirstName() + bankClient.getSecondName());

        final double commission = 30.0;
        final double percent = 2.1;
        AccountFactory accountFactory = new AccountFactory(commission, percent);
        AccountAbs creditAccount = accountFactory.newCreditAccount(bankClient, 10000.0, 1000.0);
        creditAccount.deposit(500.0);
        creditAccount.withdrawal(11000.0);
        System.out.println(creditAccount.getBalance());

        AccountAbs depositAccount = accountFactory.newDepositAccount(bankClient, 2000.0, new Date());
        creditAccount.transfer(depositAccount, 300.0);

        System.out.println(creditAccount.getBalance());
        System.out.println(depositAccount.getBalance());
    }
}
