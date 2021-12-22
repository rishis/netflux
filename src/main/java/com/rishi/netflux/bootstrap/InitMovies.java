package com.rishi.netflux.bootstrap;

import com.rishi.netflux.domain.Movie;
import com.rishi.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Natural Born Killers","Rum Diaries","Fear and loathing in Las Vegas")
        ).map(Movie::new)
                .flatMap(movieRepository::save).
                subscribe(null,null,() -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
