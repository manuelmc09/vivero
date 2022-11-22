
package com.daw.manuel.vivero.repositories;

import com.daw.manuel.vivero.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mmacho
 */
public interface ProductosRepository extends JpaRepository <Productos,Long>{
    
}
