package com.daw.manuel.vivero.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author mmacho
 */
@Entity
@Table(name = "PEDIDOS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Pedidos implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Pedidos.class);

    private static final long serialVersionUID = 10004L;

    @Id
    @Column(name = "PEDIDOS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FECHA_PEDIDO", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPedido;
    @Column(name = "PRECIO", nullable = false, precision = 6, scale = 2)
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Clientes cliente;

    @OneToOne(mappedBy = "pedido")
    private Pagos pago;

    @OneToMany(mappedBy = "pedido",
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PedidosProductos> pedidos = new ArrayList<>();

    public Pedidos(LocalDate fechaPedido, BigDecimal precio, Clientes cliente) {
        this.fechaPedido = fechaPedido;
        this.precio = precio;
        this.cliente = cliente;
    }
    
    
}
