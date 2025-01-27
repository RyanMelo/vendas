package com.ryanmelo.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;

    public PedidoDTO() {}

    public PedidoDTO(Integer cliente, BigDecimal total, List<ItemPedidoDTO> itens) {
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

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "PedidoDTO [cliente=" + cliente + ", total=" + total + ", itens=" + itens + "]";
    }
}
