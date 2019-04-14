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
    }
}
