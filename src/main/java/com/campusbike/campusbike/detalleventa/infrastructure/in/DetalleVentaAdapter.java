package com.campusbike.campusbike.detalleventa.infrastructure.in;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.detalleventa.application.service.IDetalleVentaService;
import com.campusbike.campusbike.detalleventa.domain.entity.DetalleVenta;

@Service
public class DetalleVentaAdapter implements IDetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVenta save(DetalleVenta detalleventa) {
        return detalleVentaRepository.save(detalleventa);
    }

    @Override
    public Optional<DetalleVenta> update(int id, DetalleVenta detalleVentaAct) {
        Optional<DetalleVenta> existingEnt = detalleVentaRepository.findById(id);
    
        if (existingEnt.isPresent()) {
            DetalleVenta detalleExist = existingEnt.get();

            detalleExist.setId(id);
            detalleExist.setBicicleta(detalleVentaAct.getBicicleta());
            detalleExist.setCantidad(detalleVentaAct.getCantidad());
            detalleExist.setPrecioUnitario(detalleVentaAct.getPrecioUnitario());
            detalleExist.setVenta(detalleVentaAct.getVenta());

            return Optional.of(detalleVentaRepository.save(detalleExist));

        } else {
            return Optional.empty();
        }
}

    @Override
    public Optional<DetalleVenta> deleteById(int id) {
        Optional<DetalleVenta> existingEnt = detalleVentaRepository.findById(id);

        if (existingEnt.isPresent()) {
            detalleVentaRepository.deleteById(id);
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<DetalleVenta> findById(int id) {    
        Optional<DetalleVenta> existingEnt = detalleVentaRepository.findById(id);
    
        if (existingEnt.isPresent()) {
            return existingEnt;
        } else {
            return Optional.empty();
        }
    }

    

}
