package com.daw.manuel.vivero.servicesImpl;

import com.daw.manuel.vivero.entities.Usuario;
import com.daw.manuel.vivero.repositories.UsuarioRepository;
import com.daw.manuel.vivero.services.IUserService;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmacho
 */
@Service
@Transactional
public class UsuarioServicio implements IUserService, UserDetailsService 
{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario get(long id) {
        return usuarioRepository.findById(id).get();
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Integer saveuser(Usuario user) {
        String passwd = user.getPassword();
        String name = user.getNombre();
        String encodedPasswod = passwordEncoder.encode(passwd);
        user.setPassword(encodedPasswod);
        user.setNombre(name);
        user = usuarioRepository.save(user);
        return (int) user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> opt = null;
        try {
            opt = usuarioRepository.findUserByEmail(email);

        } catch (Exception ex) {
            System.out.println("Error");
            opt = null;
        }

        org.springframework.security.core.userdetails.User springUser = null;

            // opt.isEmpty() da error
        if (opt != null && !opt.isPresent()) {
            throw new UsernameNotFoundException("El usuario-a con el email: " + email + " no ha sido encontrado");
        } else {
            Usuario user = opt.get();

            List<String> roles = user.getRoles();
            Set<GrantedAuthority> ga = new HashSet<>();
            for (String role : roles) {
                ga.add(new SimpleGrantedAuthority(role));
            }

            springUser = new org.springframework.security.core.userdetails.User(
                    email,
                    user.getPassword(),
                    ga);

        }

        return springUser;
    }
}
