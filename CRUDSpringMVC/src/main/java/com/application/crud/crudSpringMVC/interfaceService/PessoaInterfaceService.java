package com.application.crud.crudSpringMVC.interfaceService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.application.crud.crudSpringMVC.model.Pessoa;

public interface PessoaInterfaceService {
	List<Pessoa> listar();
	Pessoa findById(Integer cod);
	ResponseEntity<Pessoa> listarPorId(Integer cod);
	Pessoa incluir(Pessoa pessoa);
	Pessoa editar(Pessoa pessoa);
	void excluir(Integer cod);
}
