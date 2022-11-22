package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.PedidosProductos;
import com.daw.manuel.vivero.repositories.PedidosProductosRepository;
import com.daw.manuel.vivero.services.PedidosProductosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "PedidosProductosServiceImpl")
@Transactional
public class PedidosProductosServiceImpl implements PedidosProductosService {

    @Autowired
    private PedidosProductosRepository pedidosProductosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PedidosProductos> getAll() {
        return pedidosProductosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PedidosProductos> porId(Long id) {
        return pedidosProductosRepository.findById(id);
    }

    @Override
    public PedidosProductos nuevoPedidoProducto(PedidosProductos pedidoProducto) {
        return pedidosProductosRepository.save(pedidoProducto);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (pedidosProductosRepository.existsById(id)) {
            pedidosProductosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


