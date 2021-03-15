package com.example.service.user.infrastructure.reactive;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Getter(AccessLevel.PRIVATE)
@Value(staticConstructor = "of")
public class CollectionReactive<T> {

    Flux<T> flux;

    public Flux<T> toFlux() {
        return flux;
    }

    public <U> CollectionReactive<U> map(Function<? super T, ? extends U> mapper) {
        return CollectionReactive.of(flux.map(mapper));
    }
}

