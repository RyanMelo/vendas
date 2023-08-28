package com.ryanmelo.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanmelo.vendas.dto.PedidoDTO;
import com.ryanmelo.vendas.entity.Pedido;
import com.ryanmelo.vendas.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "")
    public ResponseEntity<Integer> salvarPedido(@RequestBody PedidoDTO pedido) {

        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo.getId());
    }

    // @GetMapping(value = "")
    // public ResponseEntity<List<Pedido>> listarPedidos() {
    //     List<Pedido> pedidos = pedidoService.listarPedidos();
    //     return ResponseEntity.ok(pedidos);
    // }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<String> getProdutoDetalhado(@PathVariable Integer id) {
    //     PedidoDTO pedidoDTO = pedidoService.getPedidoDetalhado(id);
    //     return ResponseEntity.ok().body(pedidoDTO.toString());
    // }
}
