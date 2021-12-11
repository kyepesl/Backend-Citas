package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.ICitaDao;
import com.kyepes.citasveterinarias.core.dao.IEstadoCitaDao;
import com.kyepes.citasveterinarias.core.entity.Cita;
import com.kyepes.citasveterinarias.core.entity.EstadoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService{

    @Autowired
    private ICitaDao citaDao;

    @Autowired
    private IEstadoCitaDao estadoCitaDao;

    @Override
    public Cita CrearCita(Cita cita) {

        EstadoCita estadoCita = estadoCitaDao.findByNombre("Pendiente por aprobación");
        cita.setEstadoCita(estadoCita);

        return citaDao.save(cita);
    }

    @Override
    public Boolean CambiarEstadoCita(Cita cita) {
        try {
            citaDao.save(cita);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Cita> ObtenerCitas() {
        return (List<Cita>) citaDao.findAll();
    }
}
