package com.kyepes.citasveterinarias.controller;

import com.kyepes.citasveterinarias.core.entity.TipoCita;
import com.kyepes.citasveterinarias.core.service.ITipoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class TipoCitaController {

    @Autowired
    private ITipoCitaService tipoCitaService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/tipos-citas")
    public List<TipoCita> index() {
        return tipoCitaService.ObtenerTiposCitas();
    }
}
