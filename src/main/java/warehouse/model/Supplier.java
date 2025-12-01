package warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import warehouse.model.common.Address;
import warehouse.model.common.ContactInfo;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Supplier {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private Address address;

    public Supplier(ContactInfo contactInfo, Address address) {
        this.contactInfo = contactInfo;
        this.address = address;
    }
}
