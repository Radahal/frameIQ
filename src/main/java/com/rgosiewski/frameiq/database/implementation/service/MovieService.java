package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.MovieRepository;
import com.rgosiewski.frameiq.database.definition.service.IMovieService;
import com.rgosiewski.frameiq.database.implementation.model.MovieEntity;
import com.rgosiewski.frameiq.server.movie.data.CreateMovieData;
import com.rgosiewski.frameiq.server.movie.data.EditMovieData;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import com.rgosiewski.frameiq.server.movie.populator.MovieDataFromMovieEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;
    private final MovieDataFromMovieEntityPopulator fromMovieEntityPopulator;

    public MovieService(MovieRepository movieRepository, MovieDataFromMovieEntityPopulator fromMovieEntityPopulator) {
        this.movieRepository = movieRepository;
        this.fromMovieEntityPopulator = fromMovieEntityPopulator;
    }

    @Override
    public MovieData getMovie(Long movieId) {
        return fromMovieEntityPopulator.populate(movieRepository.getById(movieId));
    }

    @Override
    public List<MovieData> listAllByBlueprintId(Long blueprintId) {
        return fromMovieEntityPopulator.populateAll(movieRepository.findAllByBlueprintId(blueprintId));
    }

    @Override
    public MovieData createMovie(CreateMovieData createMovieData) {
        MovieEntity entity = new MovieEntity();
        entity.setBlueprintId(createMovieData.getBlueprintId());
        entity.setName(createMovieData.getName());
        entity.setDescription(createMovieData.getDescription());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        return fromMovieEntityPopulator.populate(movieRepository.saveAndFlush(entity));
    }

    @Override
    public MovieData editMovie(EditMovieData editMovieData) {
        MovieEntity entity = movieRepository.getById(editMovieData.getMovieId());
        entity.setName(editMovieData.getName());
        entity.setDescription(editMovieData.getDescription());
        entity.setModificationTime(new Date());
        return fromMovieEntityPopulator.populate(movieRepository.saveAndFlush(entity));
    }
}
