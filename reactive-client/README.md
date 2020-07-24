# Ejempo de uso Spring Web Flux

[ArquitecturaJava](https://www.arquitecturajava.com/que-es-spring-webflux)

Clientes **REST** usando `RestTemplate` y `WebClient`.

Expone tres páginas html usando *thymeleaf* en:
+ [http://localhost:4002/lista](http://localhost:4002/lista)
+ [http://localhost:4002/lista/flux](http://localhost:4002/lista/flux)
+ [http://localhost:4002/lista/combinacion](http://localhost:4002/lista/combinacion)

Todas devuelven una lista de `Factura` que obtienen consultando al servicio de 
[http://localhost:4001](http://localhost:4001).

El primero hace la consulta bloqueante con `RestTemplate`.

El segundo hace la colsulta con `WebClient` al endpoint que devuelve un `Flux<Factura>`.

El tercero también hace la consulta con `WebClient` pero al mismo endpoint que el primero que 
retorna un `List<Factura>`.

## Conlusión
Vemos que lo importante es usar el `WebClient` para no bloquear sin importar si el servicio al que
se consulta devuelve un `List` o un `Flux`.

