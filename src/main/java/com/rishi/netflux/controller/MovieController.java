package com.rishi.netflux.controller;

import com.rishi.netflux.domain.Movie;
import com.rishi.netflux.domain.MovieEvent;
import com.rishi.netflux.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getById(id);
    }

    @GetMapping
    Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvent(@PathVariable String id) {
        return movieService.streamMovieEvents(id);
    }

}
