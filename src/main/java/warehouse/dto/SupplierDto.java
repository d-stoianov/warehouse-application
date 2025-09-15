package warehouse.dto;

import warehouse.model.common.Address;
import warehouse.model.common.ContactInfo;

import java.util.Objects;

public class SupplierDto {
    private ContactInfo contactInfo;
    private Address address;

    public SupplierDto(ContactInfo contactInfo, Address address) {
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SupplierDto that)) return false;
        return Objects.equals(contactInfo, that.contactInfo) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactInfo, address);
    }

    @Override
    public String toString() {
        return "SupplierDto{" +
                "contactInfo=" + contactInfo +
                ", address=" + address +
                '}';
    }
}
