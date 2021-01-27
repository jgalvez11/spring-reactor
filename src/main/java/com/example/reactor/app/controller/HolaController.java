package com.example.reactor.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactor.app.controller.service.HolaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/webflux")
public class HolaController {

	@Autowired
	private HolaService holaService;

	@GetMapping("/holaMono")
	public Mono<String> holaMono() {
		return holaService.holaMono();
	}

	@GetMapping("/holaFlux")
	public Flux<String> holaFlux() {
		return holaService.holaFlux();
	}

	@GetMapping("/holaMonoMap")
	public Mono<HashMap<String, String>> holaMonoMap() {
		return holaService.holaMonoMap();
	}

	@GetMapping("/holaFluxMap")
	public Flux<HashMap<String, String>> holaFluxMap() {
		return holaService.holaFluxMap();
	}

}
