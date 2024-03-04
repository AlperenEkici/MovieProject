package com.alperenekici.movies.business.concretes;

import com.alperenekici.movies.DataAccess.MovieDao;
import com.alperenekici.movies.Entities.Movie;
import com.alperenekici.movies.business.abstracts.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieManager implements MovieService {

    MovieDao movieDao ;

    @Autowired
    public MovieManager(MovieDao movieDao) {
        super();
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Optional<Movie> getSingleMovie(ObjectId id) {
        return movieDao.findById(id);
    }

    @Override
    public Optional<Movie> getSingleMovieImdbId(String imdbId) {
        return movieDao.findMovieByImdbId(imdbId);
    }

    @Override
    public Optional<Movie> add(Movie movie) {
        return Optional.of(movieDao.insert(movie));
    }

}
