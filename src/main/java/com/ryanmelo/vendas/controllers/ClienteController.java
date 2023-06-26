package com.ryanmelo.vendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanmelo.vendas.entity.Cliente;
import com.ryanmelo.vendas.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Cliente>> getAllClientes(Cliente filtro) {
        
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cliente> example = Example.of(filtro, matcher);

        List<Cliente> listClientes = clienteRepository.findAll(example);

        return ResponseEntity.ok(listClientes);
    }

    @PostMapping(value = "")
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);

        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> atualizaCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        
        return clienteRepository.findById(id).map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }).orElse(ResponseEntity.notFound().build());

    }

}
