package com.daw.manuel.vivero.repositories;

import com.daw.manuel.vivero.entities.Productos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mmacho
 */
public interface ProductosRepository extends JpaRepository<Productos, Long> {

    @Query("select p from Productos p where p.nombre=:nombre")
    Optional<Productos> porNombre(@Param("nombre") String nombre);

    @Query("select p from Productos p left join fetch p.categorias c where c.id=:id")
    List<Productos> porCategorias(@Param("id") Long idCategoria);
}
