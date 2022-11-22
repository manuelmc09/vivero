package com.daw.manuel.vivero.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
@Table(name = "CATEGORIAS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Categorias implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Categorias.class);

    private static final long serialVersionUID = 10003L;

    @Id
    @Column(name = "CATEGORIAS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NOMBRE", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String nombre;

    public Categorias(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(mappedBy = "categoria",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ProductosCategoria> productos = new ArrayList<>();

}
