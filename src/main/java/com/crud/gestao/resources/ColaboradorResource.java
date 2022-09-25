package com.crud.gestao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.dtos.ColaboradorDTO;
import com.crud.gestao.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborades")
public class ColaboradorResource {
	
	
	@Autowired
	private ColaboradorService service;
	
	//mapea o colaborador pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<ColaboradorDTO> findById(@PathVariable Integer id){
		Colaborador obj = service.findById(id);
		return ResponseEntity.ok().body(new ColaboradorDTO(obj));
		
	}

}
