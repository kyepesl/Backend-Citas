package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.EstadoCita;
import org.springframework.data.repository.CrudRepository;

public interface IEstadoCitaDao extends CrudRepository<EstadoCita, Long> {

    EstadoCita findByNombre(String nombre);
}
