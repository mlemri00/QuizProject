package org.mons.quizproject.DTO;

import lombok.*;
import org.mons.quizproject.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
    }

}
