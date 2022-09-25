package com.crud.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.dtos.ColaboradorDTO;
import com.crud.gestao.repositories.ColaboradorRepository;
import com.crud.gestao.services.exceptions.ObjectnotFoundException;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	 //procura o colaborador pelo id e da um response formatado caso não exista o id no banco
	public Colaborador findById(Integer id) {
		Optional<Colaborador> obj  = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" +id));
	}
	public List<Colaborador> findAll() {
		return repository.findAll();
	}
	public Colaborador create(ColaboradorDTO objDTO) {
		objDTO.setId(null);
		Colaborador newObj = new Colaborador(objDTO);
		return repository.save(newObj);
	}

}
