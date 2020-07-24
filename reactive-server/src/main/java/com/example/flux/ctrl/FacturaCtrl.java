package com.example.flux.ctrl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flux.payload.Factura;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "api/facturas")
public class FacturaCtrl {
    
    @GetMapping
    public ResponseEntity<List<Factura>> buscarTodas() {
      
        List<Factura> lista = new ArrayList<>();
        lista.add(new Factura(1, "ordenador", new BigDecimal("200")));
        lista.add(new Factura(2, "tablet", new BigDecimal("300")));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping(path = "flux")
    public ResponseEntity<Flux<Factura>> buscarTodasFlux() {
        
        Flux<Factura> lista= Flux.just(
                new Factura(1, "ordenador", new BigDecimal("200")),
                new Factura(2, "tablet", new BigDecimal("300")))
                .delaySequence(Duration.ofSeconds(3));
        return ResponseEntity.ok(lista);
    }

}
