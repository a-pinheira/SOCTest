package com.soc.exame.controllers.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.soc.exame.controllers.repositories.ExameRepository;
import com.soc.exame.models.entities.Exame;
import com.soc.exame.models.entities.enums.ExameStatus;

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
		/* Data EXAME
		 * Exame e1 = new Exame ("Hemograma", "exame de sangue", Instant.parse("2020-03-210T19:53:07Z"), 67.50);
		 * Exame e2 = new Exame ("Covid", "secreção nasal", Instant.parse("2020-06-20T19:53:07Z"), 217.50);
		 * Status EXAME
		 * Exame e1 = new Exame ("Hemograma", "exame de sangue", "2020-03-210 T19:53:07Z", ExameStatus.WAITING_PAYMENT, 67.50);
		 * Exame e2 = new Exame (" \r\n Covid", "secreção nasal", "2020-06-20 T19:53:07Z", ExameStatus.PAID, 217.50);
		*/
		 Exame e1 = new Exame ("Hemograma", "exame de sangue", "2020-03-210 T19:53:07Z", 67.50);
		 Exame e2 = new Exame (" \r\n Covid", "secreção nasal", "2020-06-20 T19:53:07Z", 217.50);
		
		 exameRepository.saveAll(Arrays.asList(e1,e2));
		
	}
}
