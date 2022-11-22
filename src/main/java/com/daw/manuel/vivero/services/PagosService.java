package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Pagos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface PagosService {

    List<Pagos> getAll();

    Optional<Pagos> porId(Long id);

    Pagos nuevoPago(Pagos clientes);

    boolean borrarPorId(Long id);

}
