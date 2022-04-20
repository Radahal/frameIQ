package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.definition.model.IUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<IUser, Long> {
}
