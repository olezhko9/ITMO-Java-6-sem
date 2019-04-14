package Client;

public class Client {
    private String firstName;
    private String secondName;
    private String address;
    private String passportNumber;

    public static ClientBuilder newClient() {
        return new ClientBuilder();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
