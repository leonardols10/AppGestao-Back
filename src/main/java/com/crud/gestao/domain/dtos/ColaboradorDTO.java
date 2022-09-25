package com.crud.gestao.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.enums.perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ColaboradorDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String nome;
	
	protected String cpf;

	protected String email;
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate datacriacao = LocalDate.now();

	public ColaboradorDTO() {
		super();
	}

	public ColaboradorDTO(Colaborador obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.datacriacao = obj.getDatacriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<perfil> getPerfis() {
		return perfis.stream().map(x -> perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDate datacriacao) {
		this.datacriacao = datacriacao;
	}

	
	
	
	

}
