/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.UserRepository;
import com.rgosiewski.frameiq.database.definition.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getUserIdByName(String name) {
        return userRepository.findByName(name).getId();
    }

    public Long getAdminId() {
        return userRepository.findByName("Admin").getId();
    }
}
