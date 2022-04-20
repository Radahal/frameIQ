package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.definition.model.IExifMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExifMetadataRepository extends JpaRepository<IExifMetadata, Long> {

}
