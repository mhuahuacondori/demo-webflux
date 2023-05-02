package org.reactivo.demowebflux.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivo.demowebflux.common.util.PropertiesExternos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import static org.reactivo.demowebflux.common.util.Constantes.*;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class DBConfig extends AbstractR2dbcConfiguration{

	private PropertiesExternos pro;

	@Override
	public ConnectionFactory connectionFactory() {	
		return ConnectionFactories.get(pro.dbURL);
	}
	
	@Bean
	public ConnectionFactoryInitializer connectionFactoryInitializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
		connectionFactoryInitializer.setConnectionFactory(connectionFactory);
		CompositeDatabasePopulator compositeDatabasePopulator = new CompositeDatabasePopulator();
		compositeDatabasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource(SCHEMA)));
		connectionFactoryInitializer.setDatabasePopulator(compositeDatabasePopulator);
		return connectionFactoryInitializer;
	}

}
