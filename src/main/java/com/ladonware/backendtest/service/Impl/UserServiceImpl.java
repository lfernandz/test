package com.ladonware.backendtest.service.Impl;

import com.ladonware.backendtest.entity.User;
import com.ladonware.backendtest.repository.UserRepository;
import com.ladonware.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User register(User user) {
        //user.setDateCreated(new Date());
        return userRepository.save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
