package com.campusbike.campusbike.venta.infrastructure.in;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusbike.campusbike.venta.domain.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
