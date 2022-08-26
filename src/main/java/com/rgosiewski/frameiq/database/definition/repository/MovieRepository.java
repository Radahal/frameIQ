package com.rgosiewski.frameiq.database.definition.repository;

import com.rgosiewski.frameiq.database.implementation.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    public List<MovieEntity> findAllByBlueprintId(Long blueprintId);
}
