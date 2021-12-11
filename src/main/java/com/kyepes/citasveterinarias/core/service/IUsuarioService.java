package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.entity.Usuario;

public interface IUsuarioService {

    Usuario Registrar(Usuario usuario);
    Usuario findByCorreo(String correo);
}
