package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "Select * from cliente c where c.cedula = :cedula", nativeQuery = true)
    public Cliente buscarCliente(String cedula);
}
