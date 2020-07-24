package com.example.thymeleaf.srvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.flux.payload.Factura;

import reactor.core.publisher.Flux;

@Service
public class FacturaService {
    
    private static final String baseUrl = "http://localhost:4001";
    
    public List<Factura> buscarTodas() {
        RestTemplate plantilla = new RestTemplate();
        List<Factura> facturas1 = Arrays.asList(
                plantilla.getForObject(baseUrl + "/facturas", Factura[].class));
        List<Factura> facturas2 = Arrays.asList(
                plantilla.getForObject(baseUrl + "/facturas", Factura[].class));
        List<Factura> facturas3 = Arrays.asList(
                plantilla.getForObject(baseUrl + "/facturas", Factura[].class));
        List<Factura> todas = new ArrayList<>();
        todas.addAll(facturas1);
        todas.addAll(facturas2);
        todas.addAll(facturas3);
        return todas;
    }

    public Flux<Factura> buscarTodasFlux() {
        
        WebClient cliente = WebClient.create(baseUrl + "/facturas/flux");
        Flux<Factura> facturas1 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas2 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas3 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> todas = Flux.merge(facturas1, facturas2, facturas3);
        return todas;
    }
    
    public Flux<Factura> buscarTodasCombinacion() {
        
        WebClient cliente = WebClient.create(baseUrl + "/facturas");
        Flux<Factura> facturas1 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas2 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas3 = cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> todas = Flux.merge(facturas1, facturas2, facturas3);
        return todas;
    }
}
