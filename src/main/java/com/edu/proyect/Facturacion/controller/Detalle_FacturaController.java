/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Facturacion.controller;


import com.edu.proyect.Facturacion.model.Detalle_Factura;
import com.edu.proyect.Facturacion.service.Detalle_FacturaService;
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
public class Detalle_FacturaController {
    
    @Autowired
    Detalle_FacturaService detalle_facturaService;

    @GetMapping("/listardetalle")
    public ResponseEntity< List<Detalle_Factura>> obtenerLista() {
        return new ResponseEntity<>(detalle_facturaService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/creardetalle")
    public ResponseEntity<Detalle_Factura> crear(@RequestBody Detalle_Factura d){
     return new ResponseEntity<>(detalle_facturaService.save(d), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminardetalle/{id_detalle_factura}")
    public void eliminar(@PathVariable("id_detalle_factura") Integer id_detalle_factura){
        detalle_facturaService.delete(id_detalle_factura);
    }
    
    @PutMapping("/actualizardetalle/{id_detalle_factura}")
    public ResponseEntity<Detalle_Factura> actualizar(@RequestBody Detalle_Factura d,@PathVariable Integer id_detalle_factura){
        Detalle_Factura detallea = detalle_facturaService.findById(id_detalle_factura);
		detallea.setCantidad(d.getCantidad());
     return new ResponseEntity<>(detalle_facturaService.save(detallea), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscardetalle/{id_detalle_factura}")
    public ResponseEntity<Detalle_Factura> buscar(@PathVariable("id_detalle_factura") Integer id_detalle_factura) {
        return new ResponseEntity<>(detalle_facturaService.findById(id_detalle_factura), HttpStatus.OK);
    }
}
