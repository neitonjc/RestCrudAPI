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
