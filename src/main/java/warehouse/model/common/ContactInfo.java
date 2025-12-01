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
public class ContactInfo {
    private String fullName;
    private String phoneNumber;
    private String email;
}
