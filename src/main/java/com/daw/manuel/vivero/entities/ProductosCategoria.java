package com.daw.manuel.vivero.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mmacho
 */
@Entity
@Table(name = "PRODUCTOS_CATEGORIAS", indexes = {
    @Index(name = "IDX_PRODUCTOS_CATEGORIAS", unique = true,
            columnList = "PRODUCTOS_ID,CATEGORIAS_ID")
})

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ProductosCategoria implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductosCategoria.class);

    private static final long serialVersionUID = 10008L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "PRODUCTOS_ID", insertable = false, updatable = false)
    private Long productosId;
    @Column(name = "CATEGORIAS_ID", insertable = false, updatable = false)
    private Long categoriasId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTOS_ID")
    private Productos producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIAS_ID")
    private Categorias categoria;

    public long getId() {
        return Id;
    }

    public ProductosCategoria(Long Id, Long productosId, Long categoriasId) {
        this.Id = Id;
        this.productosId = productosId;
        this.categoriasId = categoriasId;
    }

    public ProductosCategoria(Long productosId, Long categoriasId) {
        this.productosId = productosId;
        this.categoriasId = categoriasId;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the productosId
     */
    public long getProductosId() {
        return productosId;
    }

    /**
     * @param productosId the productosId to set
     */
    public void setProductosId(Long productosId) {
        this.productosId = productosId;
    }

    /**
     * @return the categoriasId
     */
    public long getCategoriasId() {
        return categoriasId;
    }

    /**
     * @param categoriasId the categoriasId to set
     */
    public void setCategoriasId(Long categoriasId) {
        this.categoriasId = categoriasId;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

}
