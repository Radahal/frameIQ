package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.implementation.model.BlueprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlueprintRepository extends JpaRepository<BlueprintEntity, Long> {

}
