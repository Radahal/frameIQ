package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.MovieMetadataRepository;
import com.rgosiewski.frameiq.database.definition.service.IMovieMetadataService;
import com.rgosiewski.frameiq.database.implementation.model.MovieMetadataEntity;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.CreateMovieMetadataData;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.MovieMetadataData;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.populator.MovieMetadataDataFromMovieMetadataEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieMetadataService implements IMovieMetadataService {
    private final MovieMetadataRepository movieMetadataRepository;
    private final MovieMetadataDataFromMovieMetadataEntityPopulator fromMovieMetadataEntityPopulator;

    public MovieMetadataService(MovieMetadataRepository movieMetadataRepository, MovieMetadataDataFromMovieMetadataEntityPopulator fromMovieMetadataEntityPopulator) {
        this.movieMetadataRepository = movieMetadataRepository;
        this.fromMovieMetadataEntityPopulator = fromMovieMetadataEntityPopulator;
    }

    @Override
    public MovieMetadataData getMovieMetadata(Long movieMetadataId) {
        return fromMovieMetadataEntityPopulator.populate(movieMetadataRepository.getById(movieMetadataId));
    }

    @Override
    public List<MovieMetadataData> listMovieMetadata(Long frameId) {
        return fromMovieMetadataEntityPopulator.populateAll(movieMetadataRepository.findAllByMovieId(frameId));
    }

    @Override
    public MovieMetadataData createMovieMetadata(CreateMovieMetadataData createMovieMetadataData) {
        MovieMetadataEntity entity = new MovieMetadataEntity();
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setMovieId(createMovieMetadataData.getMovieId());
        entity.setProcessedMetadata(createMovieMetadataData.getMetadata());
        //entity.setExifMetadataId(); maybe reverse logic?
        return fromMovieMetadataEntityPopulator.populate(movieMetadataRepository.saveAndFlush(entity));
    }
}
