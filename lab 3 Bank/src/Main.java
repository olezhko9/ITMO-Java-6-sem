import Account.*;
import Client.Client;

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
        AccountAbs acc = accountFactory.newCreditAccount(bankClient, 10000.0, 1000.0);
        acc.deposit(500.0);
        acc.withdrawal(11000.0);
        System.out.println(acc.getBalance());
        System.out.println(acc.getAccountOwner().getFirstName());
    }
}
