package com.campusbike.campusbike.cliente.infrastructure.in;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.cliente.application.service.IClienteService;
import com.campusbike.campusbike.cliente.domain.entity.Cliente;

@Service
public class ClienteAdapter implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> update(int id, Cliente cliente) {
        Optional<Cliente> existingEnt = clienteRepository.findById(id);

        if (existingEnt.isPresent()) {
            Cliente clienteExist = existingEnt.get();

            clienteExist.setId(id);
            clienteExist.setNombre(cliente.getNombre());
            clienteExist.setEmail(cliente.getEmail());
            clienteExist.setTelefono(cliente.getTelefono());
            clienteExist.setCiudad(cliente.getCiudad());

            return Optional.of(clienteRepository.save(clienteExist));

        } else {
            return Optional.empty();
        }
    
    }

    @Override
    public Optional<Cliente> deleteById(int id) {
        Optional<Cliente> existingEnt = clienteRepository.findById(id);

        if (existingEnt.isPresent()) {
            clienteRepository.deleteById(id);
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Cliente> findById(int id) {
        Optional<Cliente> existingEnt = clienteRepository.findById(id);
        
        if (existingEnt.isPresent()) {
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    
}
