package com.daw.manuel.vivero.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mmacho
 */
@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Productos implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Productos.class);

    private static final long serialVersionUID = 10002L;

    @Id
    @Column(name = "PRODUCTO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NOMBRE", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String nombre;
    @Column(name = "CARACTERISTICAS", nullable = false, columnDefinition = "VARCHAR(200)")
    private String caracteristicas;
    @Column(name = "STOCK", columnDefinition = "Integer default 0")
    private int stock;
    @Column(name = "PRECIO", nullable = false, precision = 6, scale = 2)
    private BigDecimal precio;

    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PedidosProductos> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "producto",
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ProductosCategoria> categorias = new ArrayList<>();

    public Productos(String nombre, String caracteristicas, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.stock = stock;
        this.precio = precio;
    }
    
    

}
