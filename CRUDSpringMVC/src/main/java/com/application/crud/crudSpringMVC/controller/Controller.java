package com.application.crud.crudSpringMVC.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
		return service.listarPorId(cod);
	}
	
	@PostMapping(path="/incluir")
	public ResponseEntity<Pessoa> incluir(@RequestParam("nome") @Valid String nome,
						  @RequestParam("email") @NotEmpty @Valid String email,
						  @RequestParam("dtNasc") @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		Pessoa p = service.incluir(new Pessoa(null, nome, email, dtNasc));
		
		return new ResponseEntity<Pessoa>(p, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/incluirObj")
	public ResponseEntity<Pessoa> incluir(@RequestBody @Valid Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.incluir(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping(path="/editar")
	public ResponseEntity<Pessoa> editar(@RequestParam("cod") Integer cod,
						 @RequestParam("nome") @Valid String nome,
						 @RequestParam("email") @Valid String email,
			  			 @RequestParam("dtNasc") @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		Pessoa p = service.findById(cod);
		return new ResponseEntity<Pessoa>(service.editar(new Pessoa(p.getCod(), nome, email, dtNasc)), HttpStatus.OK);
	}
	
	@DeleteMapping("excluir")
	public void excluir(@RequestParam("cod") Integer cod){
		service.excluir(cod);
	}
}
