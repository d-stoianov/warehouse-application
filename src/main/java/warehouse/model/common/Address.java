package warehouse.model.common;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {
    private String postcode;
    private String city;
    private String street;
    private int houseNumber;
    private String houseNumberExtension;

    public Address() {
    }
    
    public Address(String postcode, String city, String street, int houseNumber, String houseNumberExtension) {
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseNumberExtension = houseNumberExtension;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberExtension() {
        return houseNumberExtension;
    }

    public void setHouseNumberExtension(String houseNumberExtension) {
        this.houseNumberExtension = houseNumberExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return houseNumber == address.houseNumber &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(street, address.street) &&
                Objects.equals(houseNumberExtension, address.houseNumberExtension) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postcode, street, houseNumber, houseNumberExtension, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "postcode='" + postcode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", houseNumberExtension='" + houseNumberExtension + '\'' +
                '}';
    }
}
