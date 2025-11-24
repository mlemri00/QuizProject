package org.mons.quizproject.service;

import com.google.common.hash.Hashing;
import org.mons.quizproject.DAO.UserDaoOrmImpl;
import org.mons.quizproject.DTO.UserDto;
import org.mons.quizproject.models.User;

import java.nio.charset.StandardCharsets;

public class UserServiceImp {
    UserDaoOrmImpl dao = new UserDaoOrmImpl();

    public UserDto getUser(String username){
        User user = dao.getUser(username);

        if(user == null){
            return null;
        }
        return new UserDto(user);
    }

    public boolean validateUser(UserDto user, String password){
        if(user == null){
            return false;
        }
        String username = user.getUsername();
        String password2 = user.getPassword();

        if(username.equals(username) && password.equals(password2)){
            return true;
        }
        return false;
    }


    public UserDto addUser(String username, String firstName, String lastName, String password){
        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        if(dao.getUser(username) != null){
            return null;

        }

        return new UserDto(dao.addUser(new User(0L,username, firstName, lastName, hashedPassword)));

    }

}
