package com.ryanmelo.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PedidoDTO> salvarCliente(@RequestBody PedidoDTO pedido) {

        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);

        return ResponseEntity.ok().body(pedidoSalvo);
    }

}
