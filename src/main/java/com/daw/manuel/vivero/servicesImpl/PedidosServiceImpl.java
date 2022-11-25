package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Pedidos;
import com.daw.manuel.vivero.entities.PedidosProductos;
import com.daw.manuel.vivero.entities.Productos;
import com.daw.manuel.vivero.repositories.PedidosRepository;
import com.daw.manuel.vivero.repositories.ProductosRepository;
import com.daw.manuel.vivero.repositories.UsuarioRepository;
import com.daw.manuel.vivero.services.PedidosService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public Pedidos save(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    @Override
    public Pedidos nuevoPedido(Map<Productos, Integer> carrito) {
        Pedidos pedido = new Pedidos();
        List<PedidosProductos> pedidoProductos = new ArrayList<>();
        for (Entry<Productos, Integer> producto : carrito.entrySet()) {
            for (int i = 0; i < producto.getValue(); i++) {
                //revisar linea 61
                pedidoProductos.add(producto.getKey().getPedidos().get(i));
                Optional<Productos> pr = productosRepository.findById(producto.getKey().getId());
                if (pr.isPresent()) {
                    Productos pp = pr.get();
                    pp.setStock(pp.getStock() - 1);
                    productosRepository.save(pp);
                }
            }
        }
        pedido.setPedidos(pedidoProductos);
        pedido.setFechaPedido(LocalDate.now());
        //Falta en el ambito del usuario autenticado asignarle ese pedido
        
        return pedido;
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (pedidosRepository.existsById(id)) {
            pedidosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Pedidos> findPedidoUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
