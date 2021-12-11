package com.kyepes.citasveterinarias.controller;

import com.kyepes.citasveterinarias.core.entity.Usuario;
import com.kyepes.citasveterinarias.core.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Usuario usuario) {

        Usuario usuarioNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuarioNew = this.usuarioService.Registrar(usuario);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el registro del usuario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario fue registrado con éxito");
        response.put("usuario", usuarioNew);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
