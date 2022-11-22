package com.daw.manuel.vivero.repositories;

import com.daw.manuel.vivero.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mmacho
 */
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
