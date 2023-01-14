package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{
    
}
