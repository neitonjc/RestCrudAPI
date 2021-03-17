package com.application.crud.crudSpringMVC.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.application.crud.crudSpringMVC.model.Pessoa;

public interface PessoaRepository extends Repository<Pessoa, Integer>{
	
	List<Pessoa> findAll();
	Pessoa findById(Integer cod);
	Pessoa save(Pessoa pessoa);
	void delete(Pessoa pessoa);
}
