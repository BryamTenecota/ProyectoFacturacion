/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Factura;
import com.edu.proyect.Facturacion.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
public class FacturaController {
    
    @Autowired
    FacturaService facturaService;

    @GetMapping("/listarfactura")
    public ResponseEntity< List<Factura>> obtenerLista() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearfactura")
    public ResponseEntity<Factura> crear(@RequestBody Factura f){
     return new ResponseEntity<>(facturaService.save(f), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarfactura/{id_factura}")
    public void eliminar(@PathVariable("id_factura") Integer id_factura){
        facturaService.delete(id_factura);
    }
    
    @PutMapping("/actualizarfactura/{id_factura}")
    public ResponseEntity<Factura> actualizar(@RequestBody Factura f,@PathVariable Integer id_factura){
        Factura facturaa = facturaService.findById(id_factura);
		facturaa.setNumero_factura(f.getNumero_factura());
		facturaa.setFecha(f.getFecha());
     return new ResponseEntity<>(facturaService.save(facturaa), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarfactura/{id_factura}")
    public ResponseEntity<Factura> buscar(@PathVariable("id_factura") Integer id_factura) {
        return new ResponseEntity<>(facturaService.findById(id_factura), HttpStatus.OK);
    }
}
