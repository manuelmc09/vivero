package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Categorias;
import com.daw.manuel.vivero.entities.Productos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface ProductosService {

    List<Productos> getAll();

    Optional<Productos> porId(Long id);

    Productos nuevoProducto(Productos producto);

    boolean borrarPorId(Long id);

}
