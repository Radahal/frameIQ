package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.implementation.model.FrameMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrameMetadataRepository extends JpaRepository<FrameMetadataEntity, Long> {

    public List<FrameMetadataEntity> findAllByFrameId(Long frameId);
}
