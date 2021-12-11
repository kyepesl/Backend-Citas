package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.Rol;
import org.springframework.data.repository.CrudRepository;

public interface IRolDao extends CrudRepository<Rol, Long> {

    Rol findByNombre(String nombre);
}
