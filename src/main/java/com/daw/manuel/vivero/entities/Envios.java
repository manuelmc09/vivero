package com.daw.manuel.vivero.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ENVIOS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Envios implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Envios.class);

    private static final long serialVersionUID = 10006L;

    @Id
    @Column(name = "ENVIOS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DIRECCION", nullable = false, columnDefinition = "VARCHAR(80)")
    private String direccion;
    @Column(name = "FECHA_ENVIO", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaEnvio;

}
