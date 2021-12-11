package com.kyepes.citasveterinarias.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(unique= true)
    private String correo;

    @Column(length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles",
            joinColumns = @JoinColumn(name="usuario_id",nullable = true),
            inverseJoinColumns=@JoinColumn(name="rol_id",nullable = true),
            uniqueConstraints = {@UniqueConstraint(columnNames= {"usuario_id","rol_id"})})
    private List<Rol> roles;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Rol> getRoles() { return roles; }

    public void setRoles(List<Rol> roles) { this.roles = roles; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
