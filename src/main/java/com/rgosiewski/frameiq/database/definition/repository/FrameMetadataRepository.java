package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.definition.model.IFrameMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameMetadataRepository extends JpaRepository<IFrameMetadata, Long> {

}
