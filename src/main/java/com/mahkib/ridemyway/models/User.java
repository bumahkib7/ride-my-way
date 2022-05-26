package com.mahkib.ridemyway.models;



import com.mahkib.ridemyway.constants.UserType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int phoneNumber;

    private UserType userType;

    public User(String username, String password, String firstName, String lastName, String email, int phoneNumber, UserType userType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }


    public static User create(String username, String password, String firstName, String lastName, String email, int phoneNumber, UserType userType) {
        return new User (username, password, firstName, lastName, email, phoneNumber, userType);
    }

        public Long getId() {
            return id;
        }
        public void setId(String id) {
            this.id = Long.valueOf(id);
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public int getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = Integer.parseInt(phoneNumber);
        }

        public UserType getUserType() {
            return userType;
        }

}
