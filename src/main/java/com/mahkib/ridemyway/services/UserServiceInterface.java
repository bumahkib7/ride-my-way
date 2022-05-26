package com.mahkib.ridemyway.services;


import com.mahkib.ridemyway.constants.UserType;
import com.mahkib.ridemyway.models.User;



public interface UserServiceInterface {

    static void Login(String username, String password) {


    }

    void SignUp(String username, String password, String email, int phoneNumber, UserType userType);

    void Logout();

    void UpdateUser(String username, String password, String email, String phone, String role);


    void DeleteUser(User user);

}
