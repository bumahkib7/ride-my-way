package com.mahkib.ridemyway.Repo;

import com.mahkib.ridemyway.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDtoInterface extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.email= ?1")
    Optional<User> findByEmail(String user);

    @Query(value = "SELECT u FROM User u WHERE u.id = u.id")
    Optional<User> findByEmailAndPassword(String email, String password);


}
