package com.soc.desafio.exame.controllers.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.soc.desafio.exame.controllers.repositories.ExameRepository;
import com.soc.desafio.exame.models.entities.Exame;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//dependecia fraca para o ExameRepository
	//essa anotattion resolve essa dependendia e associa uma instancia do 
	//ExameRepository a este atributo
	@Autowired
	private ExameRepository exameRepository;

	@Override
	public void run(String... args) throws Exception {
		Exame e1 = new Exame ("Hemograma", "exame de sangue", "06-10-2020", 67.50);
		Exame e2 = new Exame ("Covid", "secreção nasal", "06-03-2020", 217.50);
		
		exameRepository.saveAll(Arrays.asList(e1,e2));
		
	}
}
