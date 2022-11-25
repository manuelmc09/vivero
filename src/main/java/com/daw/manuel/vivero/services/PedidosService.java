package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Pedidos;
import com.daw.manuel.vivero.entities.Productos;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface PedidosService {

    List<Pedidos> getAll();

    Optional<Pedidos> porId(Long id);

    List<Pedidos> findPedidoUser();

    Pedidos save(Pedidos pedido);

    Pedidos nuevoPedido(Map<Productos, Integer> carrito);

    boolean borrarPorId(Long id);

}
