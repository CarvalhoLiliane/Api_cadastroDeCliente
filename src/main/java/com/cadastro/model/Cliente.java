package com.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String dataNasc;
	private String email;
	private String profissao;
	private String telefone;
	
	
	public Cliente(String nome, String dataNasc, String cpf, String profissao, String telefone) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = cpf;
		this.profissao = profissao;
		this.telefone = telefone;
	}


	public Cliente() {
		super();
	}
	
	
	

}
