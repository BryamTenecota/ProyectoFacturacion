package com.edu.proyect.Facturacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.*;

@Entity

@Getter
@Setter

public class Detalle_Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_factura")
    private Integer id_detalle_factura;
    @Column(name="cantidad")
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name="id_factura",referencedColumnName ="id_factura")
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName ="id_producto")
    private Producto producto;
}
