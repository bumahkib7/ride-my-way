package com.mahkib.ridemyway.services;

import com.mahkib.ridemyway.Repo.UserDtoInterface;
import com.mahkib.ridemyway.models.User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserDto {
    private final UserDtoInterface userDtoInterface;


    public UserDto(UserDtoInterface userDtoInterface) {
        this.userDtoInterface = userDtoInterface;
    }

    public void addUserToDatabase(User user) {
        userDtoInterface.findByEmail(user.getEmail()). ifPresent(u -> {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        });
        userDtoInterface.save(user);
    }

    public void deleteUserById(Long id) {
        userDtoInterface.deleteById(id);
    }

    public void updateUser(Long id, String email, String Password) {
        User user = userDtoInterface.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

   if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
       Optional<User>existingUser = userDtoInterface
               .findByEmail(email);
         if (existingUser.isPresent()) {
             throw new RuntimeException("User with email " + email + " already exists");

         }
            user.setEmail(email);
        }

        if (Password != null && Password.length() > 0 && !Objects.equals(user.getPassword(), Password)) {
            user.setPassword(Password);
        }

        userDtoInterface.save(user);
    }


    public User findByUsername(String   username) {
        return userDtoInterface.findByEmail(username).orElseThrow(() -> new RuntimeException("User with username " + username + " not found"));
    }

    public void save(User user) {
        userDtoInterface.save(user);
    }

    public void delete(User user) {
        userDtoInterface.delete(user);
    }
}




