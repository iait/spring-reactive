package com.example.thymeleaf.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.flux.payload.Factura;
import com.example.thymeleaf.srvs.FacturaService;

@Controller
@RequestMapping(path = "lista")
public class FacturaCtrl {
  
    @Autowired
    private FacturaService servicio;
    
    @RequestMapping
    public String lista(Model modelo) {
    
        List<Factura> lista = new ArrayList<>();
        lista.addAll(servicio.buscarTodas());
    
        modelo.addAttribute("lista", lista);
        return "lista";
    }
    
    @RequestMapping("flux")
    public String listaFlux(Model modelo) {
        
        List<Factura> lista = servicio.buscarTodasFlux().collectList().block();
        
        modelo.addAttribute("lista", lista);
        return "lista";
    }
    
    @RequestMapping("combinacion")
    public String listaCombinacion(Model modelo) {
        
        List<Factura> lista = servicio.buscarTodasCombinacion().collectList().block();
        
        modelo.addAttribute("lista", lista);
        return "lista";
    }
}
