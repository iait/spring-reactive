package com.example.flux.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
public class EjemploCtrl {
    
    @GetMapping(path = "greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hola Mundo!");
    }
    
    @GetMapping(path = "echo")
    public ResponseEntity<String> echo(@RequestParam(name = "value") String value) {
        return ResponseEntity.ok(value);
    }

}
