package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Clientes;
import com.daw.manuel.vivero.entities.Pagos;
import com.daw.manuel.vivero.entities.Productos;
import com.daw.manuel.vivero.repositories.ClientesRepository;
import com.daw.manuel.vivero.repositories.PagosRepository;
import com.daw.manuel.vivero.repositories.ProductosRepository;
import com.daw.manuel.vivero.services.ClientesService;
import com.daw.manuel.vivero.services.PagosService;
import com.daw.manuel.vivero.services.ProductosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "ProductosServiceImpl")
@Transactional
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getAll() {
        return productosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> porId(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    public Productos nuevoProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (productosRepository.existsById(id)) {
            productosRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
