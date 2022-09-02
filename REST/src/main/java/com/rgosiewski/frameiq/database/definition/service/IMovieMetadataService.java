package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.CreateMovieMetadataData;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.MovieMetadataData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieMetadataService {

    public MovieMetadataData getMovieMetadata(Long movieMetadataId);

    public List<MovieMetadataData> listMovieMetadata(Long movieId);

    public MovieMetadataData createMovieMetadata(CreateMovieMetadataData createMovieMetadataData);

}
