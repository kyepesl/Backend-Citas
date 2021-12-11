package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.entity.Mascota;

import java.util.List;

public interface IMascotaService {

    Mascota CrearMascota(Mascota mascota);
    Boolean EditarMascota(Mascota mascota);
    List<Mascota> ObtenerMascotas();
    Boolean EliminarMascota(Long id);
}
