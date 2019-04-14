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

        AccountFactory accountFactory = new AccountFactory();
        AccountAbs acc = accountFactory.newSimpleAccount(bankClient, 10000.0);
        acc.deposit(500.0);
        acc.withdrawal(5000.0);
        System.out.println(acc.getBalance());
        System.out.println(acc.getAccountOwner().getFirstName());
    }
}
