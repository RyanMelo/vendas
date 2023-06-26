package com.ryanmelo.vendas;

import com.ryanmelo.vendas.repository.ClienteRepository;
import com.ryanmelo.vendas.entity.Cliente;
import com.ryanmelo.vendas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	Cliente cliente01 = new Cliente("Erik Melo");
	Cliente cliente02 = new Cliente("Marco Nunes");
	Cliente cliente03 = new Cliente("Caio Guimaraes");

	@Override
	public void run(String... args) throws Exception {

		clienteRepository.save(cliente01);
		clienteRepository.save(cliente02);
		clienteRepository.save(cliente03);

	}
}
