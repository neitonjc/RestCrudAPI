package com.application.crud.crudSpringMVC.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.crud.crudSpringMVC.interfaceService.PessoaInterfaceService;
import com.application.crud.crudSpringMVC.model.Pessoa;

@CrossOrigin(origins="http://localhost:8080", maxAge=3600)
@RestController
@RequestMapping({"/pessoa"})
public class Controller {
	@Autowired
	PessoaInterfaceService service;
	
	@GetMapping(path="/listar")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Pessoa> listar(){
		return service.listar();
	}
	
	@GetMapping(path="/listarPorId")
	public ResponseEntity<Pessoa> listarPorId(@RequestParam("cod") Integer cod){
		Pessoa p = service.listarPorId(cod);
		return new ResponseEntity<Pessoa>(p, p!=null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/listarPorNome")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Pessoa> listarPorNome(@RequestParam("nome") String nome){
		List<Pessoa> p = service.listarPorNome(nome);
		return p;
	}
	
	@PostMapping(path="/incluir")
	public ResponseEntity<Pessoa> incluir(@RequestParam("nome") @Valid String nome,
										  @RequestParam("cep")  @Valid String cep,
										  @RequestParam("email")  @Valid String email,
										  @RequestParam("dtNasc") @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		Pessoa p = service.incluir(new Pessoa(null, nome, email, cep, dtNasc));
		
		return new ResponseEntity<Pessoa>(p, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/incluirObj")
	public ResponseEntity<Pessoa> incluir(@RequestBody @Valid Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.incluir(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping(path="/editar")
	public ResponseEntity<Pessoa> editar(@RequestParam("cod") Integer cod,
						 @RequestParam("nome") @Valid String nome,
						 @RequestParam("cep")  @Valid String cep,
						 @RequestParam("email") @Valid String email,
			  			 @RequestParam("dtNasc") @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		Pessoa p = service.listarPorId(cod);
		return new ResponseEntity<Pessoa>(service.editar(new Pessoa(p.getCod(), nome, email, cep, dtNasc)), HttpStatus.OK);
	}
	
	@DeleteMapping("excluir")
	public void excluir(@RequestParam("cod") Integer cod){
		service.excluir(cod);
	}
}
