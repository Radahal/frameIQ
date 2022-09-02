package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.movie.data.CreateMovieData;
import com.rgosiewski.frameiq.server.movie.data.EditMovieData;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {

    public MovieData getMovie(Long movieId);

    public MovieData findByName(String name);

    public List<MovieData> listAllByBlueprintId(Long blueprintId);

    public MovieData createMovie(CreateMovieData createMovieData);

    public MovieData editMovie(EditMovieData editMovieData);
}
