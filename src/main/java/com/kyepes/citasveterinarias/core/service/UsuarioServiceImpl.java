package com.kyepes.citasveterinarias.core.service;

import com.kyepes.citasveterinarias.core.dao.IUsuarioDao;
import com.kyepes.citasveterinarias.core.dao.IRolDao;
import com.kyepes.citasveterinarias.core.entity.Rol;
import com.kyepes.citasveterinarias.core.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRolDao rolDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario Registrar(Usuario usuario) {

        String passwordBcrypt = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordBcrypt);

        Rol rol = rolDao.findByNombre("ROLE_USER");
        List<Rol> roles = new ArrayList<>();
        roles.add(rol);

        usuario.setRoles(roles);
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly=true)
    public Usuario findByCorreo(String correo) { return usuarioDao.findByCorreo(correo); }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByCorreo(username);

        if (usuario==null){
            logger.error("Error: no existe el correo " + username + "en el sistema");
            throw new UsernameNotFoundException("Error: no existe el correo " + username + "en el sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol-> new SimpleGrantedAuthority(rol.getNombre()))
                .peek(authority-> logger.info("Rol: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getCorreo(), usuario.getPassword(), authorities);
    }
}
