package com.application.crud.crudSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.crud.crudSpringMVC.interfaceService.PessoaInterfaceService;
import com.application.crud.crudSpringMVC.model.Pessoa;
import com.application.crud.crudSpringMVC.repository.PessoaRepository;

@Service
public class PessoaImplService implements PessoaInterfaceService {
	
	@Autowired
	private PessoaRepository rep;
	
	@Override
	public List<Pessoa> listar() {
		return rep.findAll();
	}
	
	public Pessoa findById(Integer cod) {
		return rep.findById(cod);
	}

	@Override
	public ResponseEntity<Pessoa> listarPorId(Integer cod) {
		Pessoa p = rep.findById(cod);
		
		return new ResponseEntity<Pessoa>(p, p!=null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
	}

	@Override
	public Pessoa incluir(Pessoa pessoa) {
		return rep.save(pessoa);
	}

	@Override
	public Pessoa editar(Pessoa pessoa) {
		return rep.save(pessoa);
	}

	@Override
	public void excluir(Integer cod) {
		rep.delete(new Pessoa(cod));
	}

}
