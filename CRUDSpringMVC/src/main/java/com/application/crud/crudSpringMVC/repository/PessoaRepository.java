package com.application.crud.crudSpringMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.application.crud.crudSpringMVC.model.Pessoa;

public interface PessoaRepository extends Repository<Pessoa, Integer>{
	
	public List<Pessoa> findAll();
	public Pessoa findById(Integer cod);
	
	@Query("select e from Pessoa e where e.nome like %:nome%")
	public List<Pessoa> findByName(@Param("nome") String nome); 
	
	public Pessoa save(Pessoa pessoa);
	public void delete(Pessoa pessoa);
}
