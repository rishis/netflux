package com.rishi.netflux.repositories;

import com.rishi.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
