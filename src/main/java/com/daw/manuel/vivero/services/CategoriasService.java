package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Categorias;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface CategoriasService {

    List<Categorias> getAll();

    Optional<Categorias> porId(Long id);

    Categorias nuevaCategoria(Categorias categoria);

    boolean borrarPorId(Long id);

}
