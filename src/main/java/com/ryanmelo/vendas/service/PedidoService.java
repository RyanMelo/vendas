package com.ryanmelo.vendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanmelo.vendas.dto.PedidoDTO;
import com.ryanmelo.vendas.entity.Cliente;
import com.ryanmelo.vendas.entity.ItemPedido;
import com.ryanmelo.vendas.entity.Pedido;
import com.ryanmelo.vendas.entity.Produto;
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
    public Pedido salvarPedido(PedidoDTO pedidoDTO) {
        
        Pedido pedido = new Pedido();
        Cliente cliente  = clienteRepository.findById(pedidoDTO.getCliente()).get();

        pedido.setCliente(cliente);
        pedido.setTotal(pedidoDTO.getTotal());
        

        List<ItemPedido> itens = pedidoDTO.getItens().stream().map(item -> {
            ItemPedido itemPedido = new ItemPedido();
            Produto produto = produtoRepository.findById(item.getProduto()).get();
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(item.getQuantidade());
            pedidoRepository.save(pedido);
            return itemPedido;
        }).collect(Collectors.toList());

        pedido.setItens(itens);

        pedidoRepository.save(pedido);

        return pedido;
    }

}