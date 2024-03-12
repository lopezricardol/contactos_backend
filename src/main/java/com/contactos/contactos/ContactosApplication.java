package com.contactos.contactos;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contactos.contactos.entity.Contacto;
import com.contactos.contactos.repository.ContactoRepository;
@SpringBootApplication
public class ContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactosApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactoRepository contactoRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Contacto> contactos = Arrays.asList(
					new Contacto("Carlos", "ric@hto.com", LocalDateTime.now()), 
					new Contacto("Ricardo", "ric2@hto.com", LocalDateTime.now()), 
					new Contacto("Miguel", "ric4@hto.com", LocalDateTime.now()), 
					new Contacto("Daniels", "ric5@hto.com", LocalDateTime.now())
				);
				contactoRepository.saveAll(contactos);
			}
			
		};
	}
}
