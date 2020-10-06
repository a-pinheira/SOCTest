package com.soc.desafio.exame.controllers.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soc.desafio.exame.controllers.services.ExameService;
import com.soc.desafio.exame.models.entities.Exame;

@RestController
//nome do recurso
@RequestMapping(value = "/exames")
public class ExameResource {
	
	@Autowired
	private ExameService service;
	
	//método que será o endpoint para acessar os exames
	//Anotattion que responde a um metodo do tipo GET do HTTP
	//endpoint  requisição do tipo get
	@GetMapping
	public ResponseEntity<List<Exame>> findAll() {
		List<Exame> list = service.findAll();
		return ResponseEntity.ok().body(list);
		}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Exame> findById(@PathVariable Long id){
		Exame obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
 
}
