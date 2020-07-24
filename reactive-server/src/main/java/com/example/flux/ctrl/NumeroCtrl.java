package com.example.flux.ctrl;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class NumeroCtrl {
    
    @GetMapping(path = "numeros", produces = "text/event-stream")
    public Flux<Integer> obtenerNumeros() {
        return Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1));
    }

}
