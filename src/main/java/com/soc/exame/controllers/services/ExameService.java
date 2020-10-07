package com.soc.exame.controllers.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.exame.controllers.repositories.ExameRepository;
import com.soc.exame.controllers.services.exceptions.ResourceNotFoundException;
import com.soc.exame.models.entities.Exame;


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
		//return obj.get();
		//usa lambda
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Metodo que retorna o exame salvo - insere do BD um novo objeto exame
	public Exame insert(Exame obj) {
		return repository.save(obj);
		
	}
	
	public Exame delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Exame update(Long id, Exame obj) {
		try {
			Exame entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(Exame entity, Exame obj) {
		entity.setNmExame(obj.getNmExame());
		entity.setDescricao(obj.getDescricao());
		entity.setDataExame(obj.getDataExame());
		//entity.setExameStatus(obj.getExameStatus());
		entity.setValorExame(obj.getValorExame());
	}
	
}
