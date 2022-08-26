package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.implementation.model.MovieMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMetadataRepository extends JpaRepository<MovieMetadataEntity, Long> {

    public List<MovieMetadataEntity> findAllByMovieId(Long movieId);
}
