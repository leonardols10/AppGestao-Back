package com.crud.gestao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.gestao.domain.Chamado;
import com.crud.gestao.domain.Cliente;
import com.crud.gestao.domain.Colaborador;
import com.crud.gestao.domain.enums.Prioridade;
import com.crud.gestao.domain.enums.Status;
import com.crud.gestao.domain.enums.perfil;
import com.crud.gestao.repositories.ChamadoRepository;
import com.crud.gestao.repositories.ClienteRepository;
import com.crud.gestao.repositories.ColaboradorRepository;

@SpringBootApplication
public class AppgestaoApplication implements CommandLineRunner {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private ChamadoRepository chamadorepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AppgestaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Colaborador col1 = new Colaborador(null, "leo", "98824640095", "leonardosilvalima40@gmail.com", "123");
		col1.addPerfil(perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "linus", "69360557021", "leo@teste.com.br", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", col1, cli1);
		
		
		colaboradorRepository.saveAll(Arrays.asList(col1));
		clienterepository.saveAll(Arrays.asList(cli1));
		chamadorepository.saveAll(Arrays.asList(c1));
	}

}
