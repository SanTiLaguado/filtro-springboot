package com.campusbike.campusbike.bicicleta.infrastructure.in;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.bicicleta.application.service.IBicicletaService;
import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

@Service
public class BicicletaAdapter implements IBicicletaService{

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    @Override
    public Optional<Bicicleta> update(int id, Bicicleta bicicleta) {
        Optional<Bicicleta> existingEnt = bicicletaRepository.findById(id);

        if (existingEnt.isPresent()) {
            Bicicleta existingBike = existingEnt.get();

            existingBike.setId(id);
            existingBike.setMarca(bicicleta.getMarca());
            existingBike.setModelo(bicicleta.getModelo());
            existingBike.setStock(bicicleta.getStock());

            return Optional.of(bicicletaRepository.save(existingBike));

        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Bicicleta> deleteById(int id) {
        Optional<Bicicleta> existingEnt = bicicletaRepository.findById(id);

        if (existingEnt.isPresent()) {
            bicicletaRepository.deleteById(id);
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Bicicleta> findById(int id) {
        Optional<Bicicleta> existingEnt = bicicletaRepository.findById(id);

        if (existingEnt.isPresent()) {
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

}
