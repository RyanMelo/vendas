package com.ryanmelo.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

import com.ryanmelo.vendas.entity.ItemPedido;
import com.ryanmelo.vendas.entity.Pedido;

public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedido> itens;

    public PedidoDTO() {}

    public PedidoDTO(Integer cliente, BigDecimal total, List<ItemPedido> itens) {
        this.cliente = cliente;
        this.total = total;
        this.itens = itens;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
