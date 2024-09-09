package com.campusbike.campusbike.bicicleta.infrastructure.out;

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

import com.campusbike.campusbike.bicicleta.application.service.IBicicletaService;
import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {

    @Autowired
    private IBicicletaService bicicletaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Bicicleta bicicleta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        Bicicleta savedBike = bicicletaService.save(bicicleta);
        return new ResponseEntity<>(savedBike, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Bicicleta bicicletaAct,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Optional<Bicicleta> existingEnt = bicicletaService.findById(id);
        if (!existingEnt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Bicicleta bicicletaExist = existingEnt.get();

        bicicletaExist.setMarca(bicicletaAct.getMarca());
        bicicletaExist.setModelo(bicicletaAct.getModelo());
        bicicletaExist.setStock(bicicletaAct.getStock());
        
        bicicletaService.save(bicicletaExist);

        return new ResponseEntity<>(bicicletaExist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {

        Optional<Bicicleta> bicicletaEnc = bicicletaService.findById(id);

        if (!bicicletaEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bicicletaEnc.orElseThrow(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {

        Optional<Bicicleta> bicicletaEnc = bicicletaService.findById(id);

        if (!bicicletaEnc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            bicicletaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
