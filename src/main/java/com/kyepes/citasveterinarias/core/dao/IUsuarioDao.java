package com.kyepes.citasveterinarias.core.dao;

import com.kyepes.citasveterinarias.core.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);
}
