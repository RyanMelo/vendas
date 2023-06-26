package com.ryanmelo.vendas.repository;

import com.ryanmelo.vendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findClientesByNomeLike(String nome);

    boolean existsClienteByNome(String nome);

}
