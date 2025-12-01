package warehouse.dto;

import lombok.*;
import warehouse.model.common.Address;
import warehouse.model.common.ContactInfo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SupplierDto {
    private ContactInfo contactInfo;
    private Address address;
}
