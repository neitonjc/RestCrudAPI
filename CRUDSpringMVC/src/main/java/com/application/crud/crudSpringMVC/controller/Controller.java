package com.application.crud.crudSpringMVC.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Pessoa> listar(){
		return service.listar();
	}
	
	@GetMapping(path="/listarPorId")
	public ResponseEntity<Pessoa> listarPorId(@RequestParam("cod") Integer cod){
		return service.listarPorId(cod);
	}
	
	@PostMapping(path="/incluir")
	public Pessoa incluir(@RequestParam("nome") String nome, 
						  @RequestParam("dtNasc") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		return service.incluir(new Pessoa(null, nome, dtNasc));
	}
	
	@PutMapping(path="/editar")
	public Pessoa editar(@RequestParam("cod") Integer cod,
						 @RequestParam("nome") String nome, 
			  			 @RequestParam("dtNasc") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNasc){
		Pessoa p = service.findById(cod);
		return service.editar(new Pessoa(p.getCod(), nome, dtNasc));
	}
	
	@DeleteMapping("excluir")
	public void excluir(@RequestParam("cod") Integer cod){
		service.excluir(cod);
	}
}
