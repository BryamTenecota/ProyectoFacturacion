/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
