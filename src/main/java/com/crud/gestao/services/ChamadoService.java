package com.crud.gestao.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestao.domain.Chamado;
import com.crud.gestao.domain.Cliente;
import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.dtos.ChamadoDTO;
import com.crud.gestao.domain.enums.Prioridade;
import com.crud.gestao.domain.enums.Status;
import com.crud.gestao.repositories.ChamadoRepository;
import com.crud.gestao.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	
	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private ColaboradorService colaboradorService;
	@Autowired
	private ClienteService clienteService;
	
	//servico para achar o chamado por id
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
	}


	//servico para achar todos os chamados
	public List<Chamado> findAll() {
		return repository.findAll();
	}

	//servico para criar os chamados
	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	private Chamado newChamado(ChamadoDTO obj) {
		Colaborador colaborador = colaboradorService.findById(obj.getColaborador());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setColaborador(colaborador);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}
}
