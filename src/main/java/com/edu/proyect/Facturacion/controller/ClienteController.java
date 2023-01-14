/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Cliente;
import com.edu.proyect.Facturacion.service.ClienteService;
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

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listarcliente")
    public ResponseEntity< List<Cliente>> obtenerLista() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearcliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente c){
     return new ResponseEntity<>(clienteService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarcliente/{id_cliente}")
    public void eliminar(@PathVariable("id_cliente") Integer id_cliente){
        clienteService.delete(id_cliente);
    }
    
    @PutMapping("/actualizarcliente/{id_cliente}")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente c,@PathVariable Integer id_cliente){
        Cliente clientea = clienteService.findById(id_cliente);
		clientea.setApellido(c.getApellido());
		clientea.setNombre(c.getNombre());
		clientea.setCedula(c.getCedula());
     return new ResponseEntity<>(clienteService.save(clientea), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarcliente/{id_cliente}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id_cliente") Integer id_cliente) {
        return new ResponseEntity<>(clienteService.findById(id_cliente), HttpStatus.OK);
    }
}
