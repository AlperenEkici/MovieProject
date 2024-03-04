package com.alperenekici.movies.Controllers;

import com.alperenekici.movies.Entities.Movie;
import com.alperenekici.movies.business.abstracts.MovieService;
import jakarta.websocket.server.PathParam;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>> (movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(id), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovieImdbId(imdbId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<Movie>> add(@RequestBody Movie movie){
        return new ResponseEntity<Optional<Movie>>(movieService.add(movie), HttpStatus.OK);
    }


}
