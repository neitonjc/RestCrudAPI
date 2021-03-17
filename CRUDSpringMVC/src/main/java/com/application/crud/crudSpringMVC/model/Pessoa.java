package com.application.crud.crudSpringMVC.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="PESSOA")
public class Pessoa {
	
	@Id
	@Column(name="COD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DT_NASC")
	private Date dtNasc;

	public Pessoa(Integer cod, String nome, Date dtNasc) {
		super();
		this.cod = cod;
		this.nome = nome;
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
		this.nome = nome;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
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
