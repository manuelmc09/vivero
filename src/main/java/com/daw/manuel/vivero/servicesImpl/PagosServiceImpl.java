package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Clientes;
import com.daw.manuel.vivero.entities.Pagos;
import com.daw.manuel.vivero.repositories.ClientesRepository;
import com.daw.manuel.vivero.repositories.PagosRepository;
import com.daw.manuel.vivero.services.ClientesService;
import com.daw.manuel.vivero.services.PagosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "PagosServiceImpl")
@Transactional
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pagos> getAll() {
        return pagosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pagos> porId(Long id) {
        return pagosRepository.findById(id);
    }

    @Override
    public Pagos nuevoPago(Pagos pago) {
        return pagosRepository.save(pago);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (pagosRepository.existsById(id)) {
            pagosRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
