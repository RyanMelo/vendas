package com.ryanmelo.vendas.dto;

public class ItemPedidoDTO {
    private Integer pedido;
    private Integer produto;
    private Integer quantidade;

    public ItemPedidoDTO() {}

    public ItemPedidoDTO(Integer produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
