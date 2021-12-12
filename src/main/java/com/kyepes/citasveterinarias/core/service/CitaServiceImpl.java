package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.ICitaDao;
import com.kyepes.citasveterinarias.core.dao.IEstadoCitaDao;
import com.kyepes.citasveterinarias.core.entity.Cita;
import com.kyepes.citasveterinarias.core.entity.EstadoCita;
import com.kyepes.citasveterinarias.core.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService{

    @Autowired
    private ICitaDao citaDao;

    @Autowired
    private IEstadoCitaDao estadoCitaDao;

    @Autowired
    private IMascotaService mascotaService;

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
    public List<Cita> ObtenerCitas(String usuario,List<String> roles) {
        Iterable<Cita> citas = citaDao.findAll();

        if(roles.contains("ROLE_ADMIN")){
            return (List<Cita>) citas;
        }

        List<Cita> citasUsuario = new ArrayList<>();
        Iterable<Mascota> mascotas = mascotaService.ObtenerMascotas(usuario, roles);
        List<Long> idMascotas = new ArrayList<>();
        for(Mascota m : mascotas){
            idMascotas.add(m.getId());
        }
        for (Cita cita : citas) {
            if (idMascotas.contains(cita.getMascota().getId())) {
                citasUsuario.add(cita);
            }
        }
        return citasUsuario;
    }
}
