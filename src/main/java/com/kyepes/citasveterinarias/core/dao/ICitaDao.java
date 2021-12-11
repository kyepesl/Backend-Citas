package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.Cita;
import org.springframework.data.repository.CrudRepository;

public interface ICitaDao extends CrudRepository<Cita, Long> {
}
