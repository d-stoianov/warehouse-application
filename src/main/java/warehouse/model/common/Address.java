package warehouse.model.common;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    private String postcode;
    private String city;
    private String street;
    private int houseNumber;
    private String houseNumberExtension;
}
