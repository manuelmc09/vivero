package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Clientes;
import com.daw.manuel.vivero.repositories.ClientesRepository;
import com.daw.manuel.vivero.services.ClientesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service(value = "ClientesServiceImpl")
@Transactional
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getAll() {
        return clientesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> porId(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Clientes nuevoCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (clientesRepository.existsById(id)) {
            clientesRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
