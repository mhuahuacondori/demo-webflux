package org.reactivo.demowebflux.service;

import org.reactivo.demowebflux.entity.Proveedores;
import org.reactivo.demowebflux.repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProveedoresService {

	private final ProveedoresRepository proveedoresRepository;

	public Flux<Proveedores> getAll() {
		return proveedoresRepository.findAll();
	}

	public Mono<Proveedores> getById(int proveedorid) {
		return proveedoresRepository.findById(proveedorid);
	}

	public Mono<Proveedores> save(Proveedores proveedores) {
		return proveedoresRepository.save(proveedores);
	}

	public Mono<Proveedores> update(int id, Proveedores proveedores) {
		return proveedoresRepository.save(new Proveedores(id, proveedores.getNombreprov(),
				proveedores.getContacto(), proveedores.getCeluprov(), proveedores.getFijoprov()));
	}
	
	public Mono<Void> delete(int id){
		return proveedoresRepository.deleteById(id);
	}

}
