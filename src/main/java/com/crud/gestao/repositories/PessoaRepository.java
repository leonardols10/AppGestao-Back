package com.crud.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.gestao.domain.Pessoa;
 
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
