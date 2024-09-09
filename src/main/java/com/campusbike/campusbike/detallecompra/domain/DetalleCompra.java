package com.campusbike.campusbike.detallecompra.domain;

import java.math.BigDecimal;

import com.campusbike.campusbike.compra.domain.Compra;
import com.campusbike.campusbike.repuesto.domain.entity.Repuesto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "repuesto_id", nullable = false)
    private Repuesto repuesto;

    private Integer cantidad;

    private BigDecimal precioUnitario;
}

