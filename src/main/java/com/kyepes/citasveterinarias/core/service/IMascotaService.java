package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.entity.Mascota;

import java.util.List;

public interface IMascotaService {

    Mascota CrearMascota(Mascota mascota, String email);
    Boolean EditarMascota(Mascota mascota);
    List<Mascota> ObtenerMascotas(String usuario);
    Boolean EliminarMascota(Long id);
}
