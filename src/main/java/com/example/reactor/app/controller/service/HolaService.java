package com.example.reactor.app.controller.service;

import java.util.HashMap;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HolaService {

	public Mono<String> holaMono();
	
	public Flux<String> holaFlux();
	
	public Mono<HashMap<String, String>> holaMonoMap();
	
	public Flux<HashMap<String, String>> holaFluxMap();
}
