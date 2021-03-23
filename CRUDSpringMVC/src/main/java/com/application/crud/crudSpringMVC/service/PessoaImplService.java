package com.application.crud.crudSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.application.crud.crudSpringMVC.interfaceService.PessoaInterfaceService;
import com.application.crud.crudSpringMVC.model.Pessoa;
import com.application.crud.crudSpringMVC.repository.PessoaRepository;
import com.application.crud.crudSpringMVC.to.RetornoCepTO;

@Service
public class PessoaImplService implements PessoaInterfaceService {
	
	@Autowired
	private PessoaRepository rep;
	
	@Override
	public List<Pessoa> listar() {
		return rep.findAll();
	}

	@Override
	public Pessoa listarPorId(Integer cod) {
		return rep.findById(cod);
	}

	@Override
	public Pessoa incluir(Pessoa pessoa) {
		montaObj(pessoa);
		return rep.save(pessoa);
	}

	private void montaObj(Pessoa pessoa) {
		RetornoCepTO o = consumerCEP(pessoa.getCep());
		pessoa.setRua(o.logradouro);
		pessoa.setCep(o.cep);
		pessoa.setBairro(o.bairro);
		pessoa.setCidade(o.localidade);
		pessoa.setUf(o.uf);
	}

	@Override
	public Pessoa editar(Pessoa pessoa) {
		montaObj(pessoa);
		
		return rep.save(pessoa);
	}

	@Override
	public void excluir(Integer cod) {
		rep.delete(new Pessoa(cod));
	}
	
	public RetornoCepTO consumerCEP(String cep){
		RestTemplate template = new RestTemplate();
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br/")
				.path("ws/"+cep+"/json/")
				.queryParam ("fields", "all")
				.build();
		
		return template.getForEntity(uri.toUriString(), RetornoCepTO.class).getBody();
	}

	@Override
	public List<Pessoa> listarPorNome(String nome) {
		return rep.findByName(nome.trim().toUpperCase());
	}

}
