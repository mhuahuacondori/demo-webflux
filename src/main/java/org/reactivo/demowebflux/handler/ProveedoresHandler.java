package org.reactivo.demowebflux.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivo.demowebflux.entity.Proveedores;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.reactivo.demowebflux.service.ProveedoresService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProveedoresHandler {
    private final ProveedoresService proveedoresService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        Flux<Proveedores> proveedoresFlux = proveedoresService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(proveedoresFlux,Proveedores.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest){
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Proveedores> proveedoresMono = proveedoresService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(proveedoresMono,Proveedores.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        Mono<Proveedores> proveedoresMono = serverRequest.bodyToMono(Proveedores.class);
        return proveedoresMono.flatMap(prov->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(proveedoresService.save(prov),Proveedores.class));
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest){
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Proveedores> proveedoresMono = serverRequest.bodyToMono(Proveedores.class);
        return proveedoresMono.flatMap(prov->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(proveedoresService.update(id,prov),Proveedores.class));
    }
    public Mono<ServerResponse> delete(ServerRequest serverRequest){
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(proveedoresService.delete(id),Proveedores.class);
    }

}
