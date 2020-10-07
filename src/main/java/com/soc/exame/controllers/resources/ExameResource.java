package com.soc.exame.controllers.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.soc.exame.controllers.services.ExameService;
import com.soc.exame.models.entities.Exame;


@RestController
//nome do recurso
@RequestMapping(value = "/exames")
public class ExameResource {
	
	@Autowired
	 //dependencia para o service
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
	//@PathVariable: para o spring considerar o ID como parametro que chegará na URL
	public ResponseEntity<Exame> findById(@PathVariable Long id){
		Exame obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	//endpoint para inserir
	@PostMapping
	public ResponseEntity<Exame> insert(@RequestBody Exame obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.ok().body(obj);
		return ResponseEntity.created(uri).body(obj);
	}
	
	//endpoint para deleção de exame
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		//ja trata qnd não tiver conteúdo
		return ResponseEntity.noContent().build();
	}
	
	//endpoint de atualização
	@PutMapping(value = "/{id}")
	public ResponseEntity<Exame> update(@PathVariable Long id, @RequestBody Exame obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
 
}
