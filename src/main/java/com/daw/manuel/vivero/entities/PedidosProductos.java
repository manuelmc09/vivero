package com.daw.manuel.vivero.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PEDIDOS_PRODUCTOS", indexes = {
    @Index(name = "IDX_PEDIDOS_PRODUCTOS", unique = true,
            columnList = "PEDIDOS_ID,PRODUCTOS_ID,precioFinal")
})

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

public class PedidosProductos implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PedidosProductos.class);

    private static final long serialVersionUID = 10007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "PEDIDOS_ID", insertable = false, updatable = false)
    private Long pedidosId;
    @Column(name = "PRODUCTOS_ID", insertable = false, updatable = false)
    private Long productosId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEDIDOS_ID")
    private Pedidos pedido;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTOS_ID")
    private Productos producto;
    @Column(name = "PRECIOFINAL")
    private float precioFinal;

    

    public PedidosProductos(Long Id, Long pedidosId, Long productosId, float precioFinal) {
        this.Id = Id;
        this.pedidosId = pedidosId;
        this.productosId = productosId;
        this.precioFinal = precioFinal;
    }

    public PedidosProductos(Long pedidosId, Long productosId, float precioFinal) {
        this.pedidosId = pedidosId;
        this.productosId = productosId;
        this.precioFinal = precioFinal;
    }

    /**
     * @return the Id
     */
    public long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the pedidosId
     */
    public long getPedidosId() {
        return pedidosId;
    }

    /**
     * @param pedidosId the pedidosId to set
     */
    public void setPedidosId(Long pedidosId) {
        this.pedidosId = pedidosId;
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
     * @param pedido the pedido to set
     */
    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    /**
     * @return the precioFinal
     */
    public float getPrecioFinal() {
        return precioFinal;
    }

    /**
     * @param precioFinal the precioFinal to set
     */
    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

}
