package warehouse.model;

import jakarta.persistence.*;
import warehouse.model.common.Address;
import warehouse.model.common.ContactInfo;

import java.util.Objects;

@Entity
public class Supplier {
    private @Id
    @GeneratedValue Long id;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private Address address;

    public Supplier() {
    }

    public Supplier(ContactInfo contactInfo, Address address) {
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public Long getId() {
        return id;
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
        if (!(o instanceof Supplier supplier)) return false;
        return Objects.equals(id, supplier.id) && Objects.equals(contactInfo, supplier.contactInfo) && Objects.equals(address, supplier.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactInfo, address);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", contactInfo=" + contactInfo +
                ", address=" + address +
                '}';
    }
}
