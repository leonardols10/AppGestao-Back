package com.crud.gestao.domain;

import java.util.ArrayList;
import java.util.List;

public class Colaborador extends Pessoa {
	private List<Chamado> chamados  = new ArrayList<>();

	public Colaborador() {
		super();
	}

	public Colaborador(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	

}
