package com.ryanmelo.vendas.repository;

import com.ryanmelo.vendas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
