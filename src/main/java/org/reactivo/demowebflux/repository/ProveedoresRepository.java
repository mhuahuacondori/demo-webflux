package org.reactivo.demowebflux.repository;

import org.reactivo.demowebflux.entity.Proveedores;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends ReactiveCrudRepository<Proveedores, Integer>{

}
