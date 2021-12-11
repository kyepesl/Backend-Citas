package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.TipoCita;
import org.springframework.data.repository.CrudRepository;

public interface ITipoCitaDao extends CrudRepository<TipoCita, Long> {

    TipoCita findByNombre(String nombre);
}
