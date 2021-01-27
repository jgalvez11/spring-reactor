package com.example.reactor.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ejemploFlux();
		ejemploMono();
	}

	/**
	 * Ejemplo de un Flux desde una lista
	 */
	public void ejemploFlux() {

		List<String> lista = new ArrayList<String>();
		lista.add("hola");
		lista.add("hola1");
		lista.add("hola2");
		lista.add("hola3");
		lista.add("hola4");
		lista.add("hola5");
		lista.add("hola6");

		/**
		 * Se crea el FLux mediante el fromIterable para la lista
		 */
		Flux<String> listaFlux = Flux.fromIterable(lista)
				.filter(value -> value.equals("hola4")) // Filtro para flujo de datos
				.map(value -> value + " map"); // Se transforma la información y se retorna

		// Se suscribe para imprimir el valor que se va emitiendo
		listaFlux.subscribe(System.out::println);

	}

	/**
	 * Ejemplo de un Mono simple
	 */
	public void ejemploMono() {
		// Creamos un Mono de tipo String
		Mono<String> nombre = Mono.just("Pepito");

		nombre.map(n -> "hola " + n) // Transforma la información
		.flatMap(n -> Mono.just(n + " que tal")) // Transforma la información 
		.subscribe(System.out::println); // Se capturan los eventos y se imprime el valor
	}
}
