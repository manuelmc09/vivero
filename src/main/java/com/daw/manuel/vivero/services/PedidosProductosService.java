package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.PedidosProductos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mmacho
 */
public interface PedidosProductosService {

    List<PedidosProductos> getAll();

    Optional<PedidosProductos> porId(Long id);

    PedidosProductos nuevoPedidoProducto(PedidosProductos pedidoProducto);

    boolean borrarPorId(Long id);

}
