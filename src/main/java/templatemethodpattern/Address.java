package templatemethodpattern;

public class Address {
    String streetNumber;
    String city;
    String state;
    String zipCode;

    public Address(String streetNumber, String city, String state, String zipCode) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
