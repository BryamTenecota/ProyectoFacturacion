/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Facturacion.service;

import com.edu.proyect.Facturacion.model.Detalle_Factura;
import com.edu.proyect.Facturacion.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Detalle_FacturaServiceImpl extends GenericServiceImpl<Detalle_Factura, Integer> implements Detalle_FacturaService {

    @Autowired
    DetalleFacturaRepository detallefacturaRepository;

    @Override
    public CrudRepository<Detalle_Factura, Integer> getDao() {
        return detallefacturaRepository;
    }
}
