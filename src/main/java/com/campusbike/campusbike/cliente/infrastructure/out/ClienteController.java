package com.campusbike.campusbike.cliente.infrastructure.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.campusbike.cliente.application.service.IClienteService;
import com.campusbike.campusbike.cliente.domain.entity.Cliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        Cliente nuevoCliente = clienteService.save(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Cliente clienteAct, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Optional<Cliente> existingEnt = clienteService.findById(id);
        if (!existingEnt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Cliente clienteExist = existingEnt.get();

        clienteExist.setNombre(clienteAct.getNombre());
        clienteExist.setEmail(clienteAct.getEmail());
        clienteExist.setTelefono(clienteAct.getTelefono());
        clienteExist.setCiudad(clienteAct.getCiudad());
        
        clienteService.save(clienteExist);
        return new ResponseEntity<>(clienteExist, HttpStatus.OK);
    }

        @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {

        Optional<Cliente> clienteEnc = clienteService.findById(id);

        if (!clienteEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(clienteEnc.orElseThrow(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {

        Optional<Cliente> clienteEnc = clienteService.findById(id);

        if (!clienteEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            clienteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



}
