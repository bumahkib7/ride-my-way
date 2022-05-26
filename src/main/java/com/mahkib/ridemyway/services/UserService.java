package com.mahkib.ridemyway.services;

import com.mahkib.ridemyway.Security.PasswordConfig;
import com.mahkib.ridemyway.constants.UserType;
import com.mahkib.ridemyway.models.User;


public class UserService implements UserServiceInterface {

    private static UserDto userDto;

    private static PasswordConfig passwordConfig;

    private static User user = new User();


    public UserService(UserDto userDto, PasswordConfig passwordConfig, User user) {
        UserService.userDto = userDto;
        UserService.passwordConfig = passwordConfig;
        UserService.user = user;
    }

    public static User getUser() {
        return user;
    }



    public static void Login(String username, String password) {
        User user = userDto.findByUsername(username);
        if (user != null) {
            if (PasswordConfig.bCryptPasswordEncoder().matches(password, user.getPassword())) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
                UserService userService = new UserService(userDto, passwordConfig, user);
                userService.SignUp( user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getUserType());
            }
        }

    }

    @Override
    public void SignUp(String username, String password, String email, String phone, String role) {

    }


    @Override
    public void SignUp(String username, String password, String email, int phoneNumber, UserType userType) {
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(String.valueOf(phoneNumber));
        userDto.save(user);
        System.out.println("Registered Successfully");
    }



    @Override
    public void Logout() {
        System.out.println("Logout Successful");

    }


    @Override
    public void UpdateUser(String username, String password, String email, String phone, String role) {
        user.setUsername(username);
        user.setPassword(PasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        user.setEmail(email);
        user.setPhoneNumber(phone);
        userDto.save(user);
        System.out.println("Update Successful");


    }



    @Override
    public void DeleteUser(User user) {
        userDto.delete(user);
        System.out.println("Delete Successful");

    }



    public boolean isLoggedIn() {
     return true;
    }


    public Object getUserType() {
        return user.getUserType();
    }

    }
}
