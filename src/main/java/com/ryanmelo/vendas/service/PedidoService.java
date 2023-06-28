package com.ryanmelo.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanmelo.vendas.dto.PedidoDTO;
import com.ryanmelo.vendas.entity.ItemPedido;
import com.ryanmelo.vendas.entity.Pedido;
import com.ryanmelo.vendas.repository.ClienteRepository;
import com.ryanmelo.vendas.repository.ItemPedidoRepository;
import com.ryanmelo.vendas.repository.PedidoRepository;
import com.ryanmelo.vendas.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    ClienteRepository clienteRepository;
    
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public PedidoDTO salvarPedido(Pedido pedidoParaSalvar) {
        
        itemPedidoRepository.saveAll(pedidoParaSalvar.getItens());
        Pedido pedido = pedidoRepository.saveAll(pedidoParaSalvar);
        PedidoDTO pedidoSalvo = new PedidoDTO(pedido);
        return pedidoSalvo;

    }

}
