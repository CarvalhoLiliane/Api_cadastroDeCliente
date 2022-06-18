package com.cadastro.dto;

import lombok.Data;

@Data
public class ClienteDto {
	
	private Integer id;
	private String nome;
	private String dataNasc;
	private String email;
	private String profissao;
	private String telefone;
	
	
	public ClienteDto(String nome, String dataNasc, String cpf, String profissao) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = cpf;
		this.profissao = profissao;
	}

	public ClienteDto() {
		super();
	}
	

}
