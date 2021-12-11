package com.kyepes.citasveterinarias.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="fecha_cita", nullable = false)
    private Date fechaCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="estado_cita_id",nullable = false)
    private EstadoCita estadoCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tipo_cita_id",nullable = false)
    private TipoCita tipoCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mascota_id",nullable = false)
    private Mascota mascota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public TipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
