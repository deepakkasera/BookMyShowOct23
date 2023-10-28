package com.scaler.bookmyshowoct23.services;

import com.scaler.bookmyshowoct23.models.User;
import com.scaler.bookmyshowoct23.repositories.UserRepository;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private User login(String email, String password) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        throw new RuntimeException("Incorrect Password");
    }

    public User signUp(String email, String password) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return login(email, password);
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        //Save it in the DB.
        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
