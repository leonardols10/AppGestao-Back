package com.crud.gestao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	public Colaborador findById(Integer id) {
		Optional<Colaborador> obj  = repository.findById(id);
		return obj.orElse(null);
	}

}
