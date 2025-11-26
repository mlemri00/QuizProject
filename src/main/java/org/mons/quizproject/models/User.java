package org.mons.quizproject.models;

import jakarta.persistence.*;
import lombok.*;
import org.mons.quizproject.DTO.UserDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;
    @Column(unique = true, name="username")
    private String username;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Game> gamesPlayed;

    public User(String username,String firstName,String lastName, String hashedPassword){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=hashedPassword;
    }


    public User(UserDto userDto){
        this.username = userDto.getUsername();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.password = userDto.getPassword();

    }

}
