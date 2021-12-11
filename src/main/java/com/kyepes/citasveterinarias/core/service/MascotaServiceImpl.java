package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.IMascotaDao;
import com.kyepes.citasveterinarias.core.dao.IUsuarioDao;
import com.kyepes.citasveterinarias.core.entity.Mascota;
import com.kyepes.citasveterinarias.core.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDao mascotaDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Mascota CrearMascota(Mascota mascota, String email) {

        Usuario usuario = usuarioDao.findByCorreo(email);
        mascota.setUsuario(usuario);

        return mascotaDao.save(mascota);
    }

    @Override
    public Boolean EditarMascota(Mascota mascota) {
        try {
            mascotaDao.save(mascota);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public List<Mascota> ObtenerMascotas(String usuario) {
        Iterable<Mascota> mascotas = mascotaDao.findAll();
        List<Mascota> mascotasUsuario = new ArrayList<>();
        for (Mascota mascota : mascotas) {
            if (mascota.getUsuario().getCorreo().equals(usuario)) {
                mascotasUsuario.add(mascota);
            }
        }
        return mascotasUsuario;
    }

    @Override
    public Boolean EliminarMascota(Long id) {
        try {
            Optional<Mascota> mascota = mascotaDao.findById(id);
            if (mascota.isPresent()) {
                mascotaDao.delete(mascota.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
