package com.application.crud.crudSpringMVC.interfaceService;

import java.util.List;

import com.application.crud.crudSpringMVC.model.Pessoa;
import com.application.crud.crudSpringMVC.to.RetornoCepTO;

public interface PessoaInterfaceService {
	List<Pessoa> listar();
//	Pessoa findById(Integer cod);
	public Pessoa listarPorId(Integer cod);
	
	public List<Pessoa> listarPorNome(String nome);
	
	public Pessoa incluir(Pessoa pessoa);
	
	public Pessoa editar(Pessoa pessoa);
	
	public void excluir(Integer cod);
	
	public RetornoCepTO consumerCEP(String cep);
}
