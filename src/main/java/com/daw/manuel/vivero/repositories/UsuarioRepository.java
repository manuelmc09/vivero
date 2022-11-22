package com.daw.manuel.vivero.repositories;

import com.daw.manuel.vivero.entities.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mmacho
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findUserByEmail(String email);
}
