package com.kyepes.citasveterinarias.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mascotas")
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long Id;

    @Column(name="nombre", nullable = false)
    private String Nombre;

    @Column(name="fecha_nacimiento", nullable = false)
    private Date FechaNacimiento;

    @Column(name="especie", nullable = false)
    private String Especie;

    @Column(name="sexo", nullable = false)
    private String Sexo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="usuario_id",nullable = false)
    private Usuario usuario;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
