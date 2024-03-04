package com.alperenekici.movies.business.abstracts;

import com.alperenekici.movies.Entities.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public List<Movie> getAllMovies();
    public Optional<Movie> getSingleMovie(ObjectId id);
    public Optional<Movie> getSingleMovieImdbId(String imdbId);
    Optional<Movie> add(Movie movie);

}
