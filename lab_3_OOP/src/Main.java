import account.*;
import client.*;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        Client bankClient =  new Client.Builder()
                .withFirstName("Oleg")
                .withSecondName("Naumov")
                .withAddress("Moscow")
                .withPassportNumber("999999")
                .build();

        System.out.println(bankClient.getFirstName() + bankClient.getSecondName());
        System.out.println(bankClient.getAddress());

        final double commission = 30.0;
        final double percent = 2.1;
        final double maxAmount = 1000.0;
        AccountFactory accountFactory = new AccountFactory(commission, percent, maxAmount);
        Account creditAccount = accountFactory.newCreditAccount(bankClient, 10000.0, 1000.0);
        creditAccount.deposit(500.0);
        creditAccount.withdrawal(11000.0);
        System.out.println(creditAccount.getBalance());

        Account depositAccount = accountFactory.newDepositAccount(bankClient, 2000.0, new Date());
        creditAccount.transfer(depositAccount, 300.0);

        System.out.println(creditAccount.getBalance());
        System.out.println(depositAccount.getBalance());
    }
}
