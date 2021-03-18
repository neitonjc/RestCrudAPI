package com.application.crud.crudSpringMVC.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PESSOA")
public class Pessoa {
	
	@Id
	@Column(name="COD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@NotEmpty
	@Column(name="NOME")
	private String nome;
	
	@NotEmpty
	@Email
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="RUA")
	private String rua;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="UF")
	private String uf;
	
	@NotNull
	@Column(name="DT_NASC")
	private Date dtNasc;
	

	public Pessoa(Integer cod) {
		super();
		this.cod = cod;
	}

	public Pessoa(Integer cod, String nome, String email, Date dtNasc) {
		super();
		this.cod = cod;
		setNome(nome);
		this.email = email;
		this.dtNasc = dtNasc;
	}
	
	public Pessoa(Integer cod, @NotEmpty String nome, @NotEmpty @Email String email, String cep,
			@NotNull Date dtNasc) {
		super();
		this.cod = cod;
		setNome(nome);
		this.email = email;
		this.cep = cep;
		this.dtNasc = dtNasc;
	}

	public Pessoa() {
		super();
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null)
			nome=nome.trim().toUpperCase();
		
		this.nome = nome;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIdade(){
		Calendar dtNascimento = Calendar.getInstance();
		dtNascimento.setTime(getDtNasc());;
		Calendar hoje = Calendar.getInstance();

		//calcula diferença
		int idade = hoje.get(Calendar.YEAR) - dtNascimento.get(Calendar.YEAR);
		
		return idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cod != other.cod)
			return false;
		return true;
	}
	
	
}
