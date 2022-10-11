package com.ladonware.backendtest.service;

import com.ladonware.backendtest.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User register(User user);

    Boolean existsByEmail(String email);
}
