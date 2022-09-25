package com.crud.gestao.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.crud.gestao.domain.enums.perfil;


@Entity
public class Colaborador extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "colaborador")
	private List<Chamado> chamados  = new ArrayList<>();

	public Colaborador() {
		super();
		addPerfil(perfil.CLIENTE);
	}

	public Colaborador(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(perfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	

}