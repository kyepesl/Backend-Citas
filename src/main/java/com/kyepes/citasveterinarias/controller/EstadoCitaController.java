package com.kyepes.citasveterinarias.controller;

import com.kyepes.citasveterinarias.core.entity.EstadoCita;
import com.kyepes.citasveterinarias.core.service.IEstadoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EstadoCitaController {

    @Autowired
    private IEstadoCitaService estadoCitaService;

    @GetMapping("/estados-citas")
    public List<EstadoCita> index() {
        return estadoCitaService.ObtenerEstadosCitas();
    }
}
