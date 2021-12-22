package com.rishi.netflux.service;

import com.rishi.netflux.domain.Movie;
import com.rishi.netflux.domain.MovieEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface MovieService {

    Mono<Movie> getById(String id);

    Flux<Movie> getAllMovies();

    Flux<MovieEvent> streamMovieEvents(String movieId);
}
