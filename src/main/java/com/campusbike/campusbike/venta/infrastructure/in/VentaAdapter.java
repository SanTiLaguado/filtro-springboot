package com.campusbike.campusbike.venta.infrastructure.in;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.venta.application.service.IVentaService;
import com.campusbike.campusbike.venta.domain.entity.Venta;

@Service
public class VentaAdapter implements IVentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> update(int id, Venta venta) {
        Optional<Venta> existingEnt = ventaRepository.findById(id);

        if (existingEnt.isPresent()) {
            Venta ventaExist = existingEnt.get();

            ventaExist.setId(id);
            ventaExist.setFecha(venta.getFecha());
            ventaExist.setCliente(venta.getCliente());

            return Optional.of(ventaRepository.save(ventaExist));

        } else {
            return Optional.empty();
        }

    }

    @Override
    public Optional<Venta> deleteById(int id) {
        Optional<Venta> existingEnt = ventaRepository.findById(id);

        if (existingEnt.isPresent()) {
            ventaRepository.deleteById(id);
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Venta> findById(int id) {
        Optional<Venta> existingEnt = ventaRepository.findById(id);

        if (existingEnt.isPresent()) {
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    
}
