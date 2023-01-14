package com.edu.proyect.Facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.*;

@Entity

@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer id_producto;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="precio")
    private Double precio;
    
    @Column(name="stock")
    private Integer stock;
    
    @JsonIgnore
    @OneToMany (mappedBy = "producto")
    private List<Detalle_Factura> detalles_factura;
}
