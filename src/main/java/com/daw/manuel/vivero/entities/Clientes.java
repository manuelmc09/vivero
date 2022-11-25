package com.daw.manuel.vivero.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author mmacho
 */
@Entity
@Table(name = "CLIENTES")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Clientes implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Clientes.class);

    private static final long serialVersionUID = 10001L;

    @Id
    @Column(name = "CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE", nullable = false, columnDefinition = "VARCHAR(50)")
    private String nombre;
    @Column(name = "DNI", nullable = false, columnDefinition = "VARCHAR(9)")
    private String dni;
    @Column(name = "EMAIL", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(name = "PASSWORD", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String passwd;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedidos> pedidos = new ArrayList<>();

    public Clientes(String dni, String email, String nombre, String passwd) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.passwd = passwd;
    }

}
