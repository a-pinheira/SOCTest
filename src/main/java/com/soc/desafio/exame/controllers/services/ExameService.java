package com.soc.desafio.exame.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.desafio.exame.controllers.repositories.ExameRepository;
import com.soc.desafio.exame.models.entities.Exame;


@Service 
public class ExameService {
	
	//implementar 2 op./metodos para retorno tds os exame do BD e outro por ID
	@Autowired
	private ExameRepository repository;
	
	//Busca/recupera todos
	public List<Exame> findAll(){
		return repository.findAll();
	}
	//Busca/recupera o exame por ID
	public Exame findById(Long id) {
		Optional<Exame> obj = repository.findById(id);
		return obj.get();
	}
	
	//Metodo que retorna o exame salvo
	public Exame insert(Exame obj) {
		return repository.save(obj);
		
	}
	
	
	

}
