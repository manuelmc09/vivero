package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Clientes;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface ClientesService {

    List<Clientes> getAll();

    Optional<Clientes> porId(Long id);

    Clientes nuevoCliente(Clientes clientes);

    boolean borrarPorId(Long id);

}
