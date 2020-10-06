package com.soc.desafio.exame.controllers.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soc.desafio.exame.models.entities.Exame;

@RestController
//nome do recurso
@RequestMapping(value = "/exames")
public class ExameResource {
	
	//método que será o endpoint para acessar os exames
	//Anotattion que responde a um metodo do tipo GET do HTTP
	@GetMapping
	public ResponseEntity<Exame> findAll() {
		Exame e = new Exame("Hemograma", "exame de sangue", "06-10-2020", 67.50);
		return ResponseEntity.ok().body(e);
		}

}
