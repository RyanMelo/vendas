package com.ryanmelo.vendas.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanmelo.vendas.dto.ItemPedidoDTO;
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

// {
// 	"cliente": 1,
// 	"total": 5700.00,
// 	"itens": [
// 		{
// 			"produto": 1,
// 			"quantidade": 1
// 		}
// 	]
// }

    @Transactional
    public PedidoDTO salvarPedido(PedidoDTO pedidoParaSalvarDto) {
        
        Pedido pedido = new Pedido();
        Integer idCliente = pedidoParaSalvarDto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente).get();

        pedido.setCliente(cliente);
        pedido.setTotal(pedidoParaSalvarDto.getTotal());
        pedido.setDataPedido(LocalDate.now());

        List<ItemPedido> itensPedido = converterListaPedidos(pedido, pedidoParaSalvarDto.getItens());
        
        itemPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }

    private List<ItemPedido> converterListaPedidos(Pedido pedido, List<ItemPedidoDTO> itensDto) {
        
        return itensDto.stream().map(itemPedidoDto -> {
            
            Integer idProduto = itemPedidoDto.getProduto();
            Produto produto = produtoRepository.findById(idProduto).get();
            
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemPedidoDto.getQuantidade());
            
            return itemPedido;
        }).collect(Collectors.toList());
    }
}