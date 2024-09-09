package com.campusbike.campusbike.bicicleta.infrastructure.in;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer>{

}
