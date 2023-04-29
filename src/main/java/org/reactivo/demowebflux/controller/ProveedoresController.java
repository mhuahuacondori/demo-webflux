package org.reactivo.demowebflux.controller;

import org.reactivo.demowebflux.entity.Proveedores;
import org.reactivo.demowebflux.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/proveedores")
@Slf4j
@RequiredArgsConstructor
public class ProveedoresController {

	private final ProveedoresService proveedoresRepository;
	
	@GetMapping
	public Flux<Proveedores> getAll(){
		return proveedoresRepository.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Proveedores> getById(@PathVariable("id") int proveedorid){
		return proveedoresRepository.getById(proveedorid);
	}
	
	@PostMapping
	public Mono<Proveedores> save(@RequestBody Proveedores proveedores){
		return proveedoresRepository.save(proveedores);
	}
	
	@PutMapping("/{id}")
	public Mono<Proveedores> update(@PathVariable("id") int proveedorid,@RequestBody Proveedores proveedores){
		return proveedoresRepository.update(proveedorid, proveedores);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable("id") int proveedorid){
		return proveedoresRepository.delete(proveedorid);
	}

}
