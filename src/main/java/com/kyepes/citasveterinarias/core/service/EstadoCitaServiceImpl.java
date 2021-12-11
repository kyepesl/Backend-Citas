package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.IEstadoCitaDao;
import com.kyepes.citasveterinarias.core.entity.EstadoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCitaServiceImpl implements IEstadoCitaService {

    @Autowired
    private IEstadoCitaDao estadoCitaDao;

    @Override
    public List<EstadoCita> ObtenerEstadosCitas() {
        return (List<EstadoCita>) estadoCitaDao.findAll();
    }
}
