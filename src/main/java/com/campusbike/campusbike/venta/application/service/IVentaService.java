package com.campusbike.campusbike.venta.application.service;

import java.util.Optional;

import com.campusbike.campusbike.venta.domain.entity.Venta;

public interface IVentaService {

    // create
    Venta save(Venta venta);

    // update
    Optional<Venta> update(int id, Venta venta);

    // delete
    Optional<Venta> deleteById(int id);

    // find by id
    Optional<Venta> findById(int id);
}
