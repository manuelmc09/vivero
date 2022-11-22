package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Pedidos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface PedidosService {

    List<Pedidos> getAll();

    Optional<Pedidos> porId(Long id);

    Pedidos nuevoPedido(Pedidos pedido);

    boolean borrarPorId(Long id);

}
