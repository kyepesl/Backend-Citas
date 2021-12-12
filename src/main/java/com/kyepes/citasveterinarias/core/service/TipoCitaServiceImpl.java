package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.ITipoCitaDao;
import com.kyepes.citasveterinarias.core.entity.TipoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCitaServiceImpl implements ITipoCitaService{

    @Autowired
    private ITipoCitaDao tipoCitaDao;

    @Override
    public List<TipoCita> ObtenerTiposCitas() {
        return (List<TipoCita>) tipoCitaDao.findAll();
    }
}
