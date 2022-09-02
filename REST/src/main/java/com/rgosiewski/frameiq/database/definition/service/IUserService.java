package com.rgosiewski.frameiq.database.definition.service;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public Long getUserIdByName(String name);

    public Long getAdminId();
}
