package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.model.Detalle_Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<Detalle_Factura, Integer>{
    
}
