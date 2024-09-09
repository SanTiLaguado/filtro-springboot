package com.campusbike.campusbike.detalleventa.infrastructure.in;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.detalleventa.domain.entity.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{

}
