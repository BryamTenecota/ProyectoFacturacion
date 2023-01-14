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
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Integer id_factura;
    @Column(name="numero_factura")
    private Integer numero_factura;
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_cliente",referencedColumnName ="id_cliente")
    private Cliente cliente;
    
    @JsonIgnore
    @OneToMany(mappedBy = "factura")
    private List<Detalle_Factura> detalle_factura;
}
