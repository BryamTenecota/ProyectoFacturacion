/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Producto;
import com.edu.proyect.Facturacion.service.ProductoService;
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
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping("/listarproducto")
    public ResponseEntity< List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearproducto")
    public ResponseEntity<Producto> crear(@RequestBody Producto p){
     return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarproducto/{id_producto}")
    public void eliminar(@PathVariable("id_producto") Integer id_producto){
        productoService.delete(id_producto);
    }
    
    @PutMapping("/actualizarproducto/{id_producto}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto p,@PathVariable Integer id_producto){
        Producto productoa = productoService.findById(id_producto);
		productoa.setNombre(p.getNombre());
                productoa.setPrecio(p.getPrecio());
                productoa.setStock(p.getStock());
     return new ResponseEntity<>(productoService.save(productoa), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarproducto/{id_producto}")
    public ResponseEntity<Producto> buscar(@PathVariable("id_producto") Integer id_producto) {
        return new ResponseEntity<>(productoService.findById(id_producto), HttpStatus.OK);
    }
}
