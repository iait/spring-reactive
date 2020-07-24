package com.example.flux.payload;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    private Integer numero;
    private String concepto;
    private BigDecimal importe;
    
}
