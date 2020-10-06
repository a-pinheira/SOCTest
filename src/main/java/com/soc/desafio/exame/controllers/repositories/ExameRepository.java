package com.soc.desafio.exame.controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soc.desafio.exame.models.entities.Exame;

//é capaz de instaciar um objeto repository com várias operaçoes para tratar a entity exame
public interface ExameRepository extends JpaRepository<Exame, Long>{

}
