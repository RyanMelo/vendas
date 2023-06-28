package com.ryanmelo.vendas.repository;

import com.ryanmelo.vendas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Pedido saveAll(Pedido pedidoParaSalvar);}
