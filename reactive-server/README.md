# Ejempo de uso Spring Web Flux

[ArquitecturaJava](https://www.arquitecturajava.com/que-es-spring-webflux)

Servidor **REST** común con dos endpoints:
+ [http://localhost:4001/api/facturas](http://localhost:4001/api/facturas)
+ [http://localhost:4001/api/facturas/flux](http://localhost:4001/api/facturas/flux)

Ambos generan dos elementos de `Factura` y los devuelven como respuesta luego de 3 segundos.
El primero en forma de lista con `List<Factura>` y el segundo en un objeto `Flux<Factura>`.

