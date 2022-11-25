package com.daw.manuel.vivero.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author mmacho
 */
@Entity
@Table(name = "PAGOS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Pagos implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Pagos.class);

    private static final long serialVersionUID = 10005L;

    @Id
    @Column(name = "PAGOS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FECHA_PAGO", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPago;
    @Column(name = "PRECIO_PAGO")
    private float precioPago;
    @Column(name = "TIPO_PAGO", nullable = false, length = 8)
    @Enumerated(value = EnumType.STRING)
    private TipodePago tipoPago;
    
    @OneToOne
    @JoinColumn(name = "PEDIDOS_ID")
    private Pedidos pedido;

}
