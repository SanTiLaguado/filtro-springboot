package com.campusbike.campusbike.bicicleta.application.service;

import java.util.Optional;

import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

public interface IBicicletaService {
    // create
    Bicicleta save(Bicicleta bicicleta);

    // update
    Optional<Bicicleta> update(int id, Bicicleta bicicleta);

    // delete
    Optional<Bicicleta> deleteById(int id);

    // find by id
    Optional<Bicicleta> findById(int id);
}
