package com.crud.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestao.domain.Chamado;
import com.crud.gestao.repositories.ChamadoRepository;
import com.crud.gestao.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	
	@Autowired
	private ChamadoRepository repository;
	
	
	//servico para achar o chamado por id
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
	}


	//servico para achar todos os chamados
	public List<Chamado> findAll() {
		return repository.findAll();
	}
}
