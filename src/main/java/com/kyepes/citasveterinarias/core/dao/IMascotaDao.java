package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface IMascotaDao extends CrudRepository<Mascota, Long> {
}
