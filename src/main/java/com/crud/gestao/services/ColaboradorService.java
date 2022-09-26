package com.crud.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.Pessoa;
import com.crud.gestao.domain.dtos.ColaboradorDTO;
import com.crud.gestao.repositories.ColaboradorRepository;
import com.crud.gestao.repositories.PessoaRepository;
import com.crud.gestao.services.exceptions.DataIntegrityViolationException;
import com.crud.gestao.services.exceptions.ObjectnotFoundException;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	
	//procura o colaborador pelo id e da um response formatado caso não exista o id no banco
	@Autowired
	private PessoaRepository pessoarepository;
	public Colaborador findById(Integer id) {
		Optional<Colaborador> obj  = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" +id));
	}
	public List<Colaborador> findAll() {
		return repository.findAll();
	}
	public Colaborador create(ColaboradorDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfeEmail(objDTO);
		Colaborador newObj = new Colaborador(objDTO);
		return repository.save(newObj);
	}
	private void validaPorCpfeEmail(ColaboradorDTO objDTO) {
		Optional<Pessoa> obj = pessoarepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Cpf já cadastrado no sistema");  // caso já exista o cpf
		}
		obj = pessoarepository.findByEmail(objDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail  já cadastrado no sistema"); // caso já exista o email
		}

	}

}
