package warehouse.dto;

import lombok.Getter;
import lombok.Setter;
import warehouse.model.UserRole;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
}