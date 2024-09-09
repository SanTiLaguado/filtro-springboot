package com.campusbike.campusbike.detalleventa.application.service;

import java.util.Optional;

import com.campusbike.campusbike.detalleventa.domain.entity.DetalleVenta;

public interface IDetalleVentaService {

    // create
    DetalleVenta save(DetalleVenta detalleventa);

    // update
    Optional<DetalleVenta> update(int id, DetalleVenta detalleVentaAct);

    // delete
    Optional<DetalleVenta> deleteById(int id);

    // find by id
    Optional<DetalleVenta> findById(int id);
}
