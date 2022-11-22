package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Categorias;
import com.daw.manuel.vivero.repositories.CategoriasRepository;
import com.daw.manuel.vivero.services.CategoriasService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "CategoriasServiceImple")
@Transactional
public class CategoriasServiceImpl implements CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> getAll() {
        return categoriasRepository.findAll();
    }

    @Override
        @Transactional(readOnly = true)
    public Optional<Categorias> porId(Long id) {
        return categoriasRepository.findById(id);
    }

    @Override
    public Categorias nuevaCategoria(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (categoriasRepository.existsById(id)) {
            categoriasRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
