package com.ryanmelo.vendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanmelo.vendas.entity.Produto;
import com.ryanmelo.vendas.repository.ProdutoRepository;


@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Produto>> getProdutos(Produto filtro) {
        
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Produto> exampleProduto = Example.of(filtro, matcher);

        List<Produto> listProdutos = produtoRepository.findAll(exampleProduto);

        return ResponseEntity.ok(listProdutos);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }
    

}
