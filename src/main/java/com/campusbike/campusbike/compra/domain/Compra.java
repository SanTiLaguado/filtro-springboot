package com.campusbike.campusbike.compra.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.campusbike.campusbike.detallecompra.domain.DetalleCompra;
import com.campusbike.campusbike.proveedor.domain.Proveedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    private BigDecimal total;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detallesCompras;
}

