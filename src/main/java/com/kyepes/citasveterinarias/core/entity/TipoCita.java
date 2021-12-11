package com.kyepes.citasveterinarias.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tipos_citas")
public class TipoCita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
