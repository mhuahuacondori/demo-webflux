package org.reactivo.demowebflux.router;

import lombok.extern.slf4j.Slf4j;
import org.reactivo.demowebflux.handler.ProveedoresHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.reactivo.demowebflux.common.util.Constantes.*;


@Configuration
@Slf4j
public class ProveedoresRouter {
    @Bean
    RouterFunction<ServerResponse> router(ProveedoresHandler proveedoresHandler){
        return RouterFunctions.route()
                .GET(PATH,proveedoresHandler::getAll)
                .GET(PATH.concat(REQUEST_ID),proveedoresHandler::getById)
                .POST(PATH, proveedoresHandler::save)
                .PUT(PATH.concat(REQUEST_ID), proveedoresHandler::update)
                .DELETE(PATH.concat(REQUEST_ID),proveedoresHandler::delete)
                .build();
    }

}
