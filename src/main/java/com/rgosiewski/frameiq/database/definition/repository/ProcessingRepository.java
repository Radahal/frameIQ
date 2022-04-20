package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.definition.model.IProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingRepository extends JpaRepository<IProcessing, Long> {

}
