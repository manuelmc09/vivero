package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Pedidos;
import com.daw.manuel.vivero.repositories.PedidosRepository;
import com.daw.manuel.vivero.services.PedidosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "PedidosServiceImpl")
@Transactional
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pedidos> getAll() {
        return pedidosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedidos> porId(Long id) {
        return pedidosRepository.findById(id);
    }

    @Override
    public Pedidos nuevoPedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (pedidosRepository.existsById(id)) {
            pedidosRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
