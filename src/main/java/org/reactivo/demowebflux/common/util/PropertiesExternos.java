package org.reactivo.demowebflux.common.util;

import  org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesExternos {

    @Value("${spring.r2dbc.url}")
    public String dbURL;
}
