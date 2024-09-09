package com.campusbike.campusbike.cliente.application.service;

import java.util.Optional;

import com.campusbike.campusbike.cliente.domain.entity.Cliente;

public interface IClienteService {

    // create
    Cliente save(Cliente cliente);

    // update
    Optional<Cliente> update(int id, Cliente cliente);

    // delete
    Optional<Cliente> deleteById(int id);

    // find by id
    Optional<Cliente> findById(int id);
}
