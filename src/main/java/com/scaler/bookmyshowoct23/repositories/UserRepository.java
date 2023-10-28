package com.scaler.bookmyshowoct23.repositories;

import com.scaler.bookmyshowoct23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //SQL queries.

    @Override
    ///@Query(............)
    Optional<User> findById(Long aLong);
    //select * from user where id = aLong

    Optional<User> findByEmail(String email);
    //select * from user where email_id = email;


    @Override
    User save(User user);
}

//JPA (Java Persistence API) Repository.

//Create a Repository:
//1. Class -> Interface.
//2. extend -> JPARepository
