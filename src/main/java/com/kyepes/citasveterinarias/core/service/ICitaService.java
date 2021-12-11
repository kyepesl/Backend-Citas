package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.entity.Cita;

import java.util.List;
import java.util.Optional;

public interface ICitaService {

    Cita CrearCita(Cita cita);
    Boolean CambiarEstadoCita(Cita cita);
    List<Cita> ObtenerCitas();
}
