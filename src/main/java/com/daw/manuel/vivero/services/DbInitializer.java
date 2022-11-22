package com.daw.manuel.vivero.services;

import com.daw.manuel.vivero.entities.Categorias;
import com.daw.manuel.vivero.entities.Clientes;
import com.daw.manuel.vivero.entities.Pedidos;
import com.daw.manuel.vivero.entities.Productos;
import com.daw.manuel.vivero.repositories.CategoriasRepository;
import com.daw.manuel.vivero.repositories.ClientesRepository;
import com.daw.manuel.vivero.repositories.EnviosRepository;
import com.daw.manuel.vivero.repositories.PagosRepository;
import com.daw.manuel.vivero.repositories.PedidosProductosRepository;
import com.daw.manuel.vivero.repositories.PedidosRepository;
import com.daw.manuel.vivero.repositories.ProductosCategoriaRepository;
import com.daw.manuel.vivero.repositories.ProductosRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mmacho
 */
@Service
public class DbInitializer {

    private final static Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private CategoriasRepository categoriasRepository;
    @Autowired
    private EnviosRepository enviosRepository;
    @Autowired
    private PagosRepository pagosRepository;
    @Autowired
    private PedidosProductosRepository pedidosProductosRepository;
    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private ProductosRepository productosRepository;
//    @Autowired
//    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void initDb() {
        logger.info("Init DB....");
        //  Categorias
        logger.info("Create Categorias objects ....");
        List<Categorias> lasCategorias = new ArrayList<>();
        Categorias[] lasCat = {new Categorias("DE TEMPORADA"), new Categorias("EN MACETA")
        };
        for (Categorias cat : lasCat) {
            categoriasRepository.save(cat);
            logger.info("Categoria insertada correctamente");
        }
        //  Clientes
        logger.info("Create Clientes objects ....");
        List<Clientes> losClientes = new ArrayList<>();
        Clientes[] losCli = {new Clientes("10893554H", "manuelmc09@gmail.com", "manuel", "VICtor/1975_*!"),
            new Clientes("76893558P", "josemaria10@gmail.com", "jose maria", "JOSEmaria")
        };
        for (Clientes cli : losCli) {
            clientesRepository.save(cli);
            logger.info("Cliente insertado correctamente");
        }
        //  Productos
        logger.info("Create Productos objects ....");
        List<Productos> losProductos = new ArrayList<>();
        Productos[] productos = {
            new Productos( "Manzano Reineta Roja","Reineta Roja del Canada, Francesa, de Chapa, Garciasol etc es la más típica en Asturias ya que estos árboles tienden a formar en copa",BigDecimal.valueOf(8.95), 55)
        };
        for (Productos p : productos) {
            productosRepository.save(p);
            logger.info("Producto insertado correctamente");
        }
        //  Pedidos
        logger.info("Create Pedidos objects ....");
        List<Pedidos> losPedidos= new ArrayList<>();
        Pedidos[] pedidos = {
            new Pedidos(LocalDate.parse("2022-12-07"), BigDecimal.valueOf(152.15),losCli[0]),      
            new Pedidos(LocalDate.parse("2022-12-15"), BigDecimal.valueOf(107.4),losCli[0]),
            new Pedidos(LocalDate.parse("2022-12-10"), BigDecimal.valueOf(196.9),losCli[1])
        };
        for (Pedidos pe : pedidos) {
            pedidosRepository.save(pe);
            logger.info("Pedido insertado correctamente");
        }
    }
}
