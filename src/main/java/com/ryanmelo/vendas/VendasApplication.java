package com.ryanmelo.vendas;

import com.ryanmelo.vendas.repository.ClienteRepository;
import com.ryanmelo.vendas.entity.Cliente;
import com.ryanmelo.vendas.entity.Produto;
import com.ryanmelo.vendas.repository.ProdutoRepository;

import java.math.BigDecimal;

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
	ProdutoRepository produtoRepository;

	Cliente cliente01 = new Cliente("Erik Melo");
	Cliente cliente02 = new Cliente("Marco Nunes");
	Cliente cliente03 = new Cliente("Caio Guimaraes");

	Produto produto01 = new Produto("Notebook Avell a72", BigDecimal.valueOf(5700));
	Produto produto02 = new Produto("Notebook Dell g15", BigDecimal.valueOf(5900));
	Produto produto03 = new Produto("Notebook Avell a52", BigDecimal.valueOf(4800));

	@Override
	public void run(String... args) throws Exception {

		clienteRepository.save(cliente01);
		clienteRepository.save(cliente02);
		clienteRepository.save(cliente03);

		produtoRepository.save(produto01);
		produtoRepository.save(produto02);
		produtoRepository.save(produto03);

	}
}
