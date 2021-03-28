package com.desafio.pedro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PedroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedroApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/tarefas").allowedOrigins("http://10.0.0.107:19000");
				registry.addMapping("/cadastrar").allowedOrigins("http://10.0.0.107:19000");
				registry.addMapping("/deletarTarefa/{id}").allowedOrigins("http://10.0.0.107:19000")
						.allowedMethods("DELETE");
				registry.addMapping("/buscarPorNome/{nome}").allowedOrigins("http://10.0.0.107:19000");
				registry.addMapping("/alterarTarefa/{id}").allowedOrigins("http://10.0.0.107:19000")
						.allowedMethods("PUT");
			}
		};
	}

}
