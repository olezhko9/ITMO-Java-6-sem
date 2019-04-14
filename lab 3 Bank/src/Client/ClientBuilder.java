package Client;

public class ClientBuilder {
    private Client client;

    public ClientBuilder() {
        client = new Client();
    }

    public ClientBuilder setFirstName(String firstName) {
        client.setFirstName(firstName);
        return this;
    }

    public ClientBuilder setSecondName(String secondName) {
        client.setSecondName(secondName);
        return this;
    }

    public ClientBuilder setAddress(String address) {
        client.setAddress(address);
        return this;
    }

    public ClientBuilder setPassportNumber(String passportNumber) {
        client.setPassportNumber(passportNumber);
        return this;
    }

    public Client build() {
        return client;
    }
}
