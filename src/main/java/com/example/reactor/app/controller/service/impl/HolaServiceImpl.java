package com.example.reactor.app.controller.service.impl;

import java.time.Duration;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.reactor.app.controller.service.HolaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HolaServiceImpl implements HolaService {

	@Override
	public Mono<String> holaMono() {
		// Se simula respuesta de un servicio
		return Mono.just("Hola").delayElement(Duration.ofSeconds(2));
	}

	@Override
	public Flux<String> holaFlux() {
		// Se invocan dos servicios en paralelo
		Mono<String> hola1 = holaMono();
		Mono<String> hola2 = holaMono();
		
		// El merge une las dos respuestas y retorna el Flux con la respuesta
		return Flux.merge(hola1, hola2);
	}

	@Override
	public Mono<HashMap<String, String>> holaMonoMap() {
		// Creación de un objeto
		HashMap<String, String> map = new HashMap<>();
		// Se invocan dos servicios en paralelo
		Mono<String> hola1 = holaMono();
		Mono<String> hola2 = holaMono();
		
		// El operador zip une los valores y retorna un Mono
		return Mono.zip(hola1, hola2).flatMap(value -> {
			map.put("hola1", value.getT1()); // Se referencian por tuplas
			map.put("hola2", value.getT2()); // Se referencian por tuplas
			return Mono.just(map); // Retorna un Mono con el Objeto creado
		});
	}

	@Override
	public Flux<HashMap<String, String>> holaFluxMap() {
		// Creación de un objeto
		HashMap<String, String> map = new HashMap<>();
		// Se invocan dos servicios en paralelo
		Mono<String> hola1 = holaMono();
		Mono<String> hola2 = holaMono();
		
		// El operador merge une las respuestas y retorna un Flux con el resultado
		return Flux.merge(hola1, hola2).flatMap(p -> {
			map.put(p, p);
			return Flux.just(map);
		});
	}

}
