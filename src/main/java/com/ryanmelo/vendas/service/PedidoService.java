package com.ryanmelo.vendas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanmelo.vendas.dto.PedidoDTO;
import com.ryanmelo.vendas.entity.Cliente;
import com.ryanmelo.vendas.entity.ItemPedido;
import com.ryanmelo.vendas.entity.Pedido;
import com.ryanmelo.vendas.entity.Produto;
import com.ryanmelo.vendas.exceptions.ServiceExceptionMessage;
import com.ryanmelo.vendas.repository.ClienteRepository;
import com.ryanmelo.vendas.repository.ItemPedidoRepository;
import com.ryanmelo.vendas.repository.PedidoRepository;
import com.ryanmelo.vendas.repository.ProdutoRepository;

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


    public Pedido salvarPedido(PedidoDTO pedidoDTO) {

        Integer idCliente = pedidoDTO.getCliente();

        Cliente cliente = clienteRepository.findById(idCliente).get();

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());
        pedido.setTotal(pedidoDTO.getTotal());

        List<ItemPedido> itens = converterListarPedidos(pedido,  pedidoDTO.getItens());

        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itens);

        pedido.setItens(itens);
        // Cliente
        // Data
        // total
        // itens
        return pedido;
    }

    private List<ItemPedido> converterListarPedidos(Pedido pedido, List<ItemPedido> list) {

        if(list.isEmpty()) {
            throw new ServiceExceptionMessage("Itens vazio");
        }
        
        return list.stream().map(item -> { 
            Integer idProduto = item.getProduto().getId();
            Produto produto = produtoRepository
                .findById(idProduto)
                .orElseThrow(
                    () -> new ServiceExceptionMessage("Produto não encontrado")
                );

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(item.getQuantidade());
            return itemPedido;
        }).collect(Collectors.toList());

    }   

}