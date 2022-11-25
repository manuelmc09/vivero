package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Productos;
import com.daw.manuel.vivero.repositories.ProductosRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author mmacho
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService {

    private static final Logger logger = LoggerFactory.getLogger(CarritoService.class);

    private Map<Productos, Integer> carrito = new HashMap<>();

    @Autowired
    public ProductosRepository productosRepository;

    public void addCarrito(Long id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            if (carrito.containsKey(producto.get())) {
                carrito.replace(producto.get(), carrito.get(producto.get()) + 1);
            } else {
                carrito.put(producto.get(), 1);
            }
            totalPriceCarrito();
        }
    }

    public void deleteItemCarrito(Long id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (carrito.get(producto.get()) > 1) {
            carrito.replace(producto.get(), carrito.get(producto.get()) - 1);
        } else if (carrito.get(producto.get()) == 1) {
            carrito.remove(producto.get());
        }
    }

    public void emptyCarrito() {
        carrito.clear();
    }

    public Float totalPriceCarrito() {
        float precio = 0;
        for (Entry<Productos, Integer> producto : carrito.entrySet()) {
            precio += producto.getKey().getPrecio() * producto.getValue();
        }
        return precio;
    }
}
