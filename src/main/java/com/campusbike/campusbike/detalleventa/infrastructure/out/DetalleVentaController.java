package com.campusbike.campusbike.detalleventa.infrastructure.out;

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

import com.campusbike.campusbike.detalleventa.application.service.IDetalleVentaService;
import com.campusbike.campusbike.detalleventa.domain.entity.DetalleVenta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/detalleventa")
public class DetalleVentaController {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody DetalleVenta detalleVenta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        DetalleVenta nuevoDetalle = detalleVentaService.save(detalleVenta);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody DetalleVenta detalleVentaAct,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Optional<DetalleVenta> existingEnt = detalleVentaService.findById(id);
        if (!existingEnt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        DetalleVenta detalleExist = existingEnt.get();

        detalleExist.setId(id);
        detalleExist.setBicicleta(detalleVentaAct.getBicicleta());
        detalleExist.setCantidad(detalleVentaAct.getCantidad());
        detalleExist.setPrecioUnitario(detalleVentaAct.getPrecioUnitario());
        detalleExist.setVenta(detalleVentaAct.getVenta());
        
        detalleVentaService.save(detalleExist);

        return new ResponseEntity<>(detalleExist, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {

        Optional<DetalleVenta> detalleEnc = detalleVentaService.findById(id);

        if (!detalleEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(detalleEnc.orElseThrow(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {

        Optional<DetalleVenta> detalleEnc = detalleVentaService.findById(id);

        if (!detalleEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            detalleVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
