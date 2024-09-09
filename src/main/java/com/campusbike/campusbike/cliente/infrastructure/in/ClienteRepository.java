package com.campusbike.campusbike.cliente.infrastructure.in;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusbike.campusbike.cliente.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
