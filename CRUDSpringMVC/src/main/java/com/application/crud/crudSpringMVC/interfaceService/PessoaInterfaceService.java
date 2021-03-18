package com.application.crud.crudSpringMVC.interfaceService;

import java.util.List;

import com.application.crud.crudSpringMVC.model.Pessoa;
import com.application.crud.crudSpringMVC.to.RetornoCepTO;

public interface PessoaInterfaceService {
	List<Pessoa> listar();
	Pessoa findById(Integer cod);
	Pessoa listarPorId(Integer cod);
	Pessoa incluir(Pessoa pessoa);
	Pessoa editar(Pessoa pessoa);
	void excluir(Integer cod);
	
	public RetornoCepTO consumerCEP(String cep);
}
