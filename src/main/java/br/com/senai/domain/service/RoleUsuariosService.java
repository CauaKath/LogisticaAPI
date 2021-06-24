package br.com.senai.domain.service;

import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleUsuariosService {

    private RoleUsuariosRepository roleUsuarioRepository;

    public RoleUsuarios cadastrarRoleUsuario(RoleUsuarios roleUsuario) {
        return roleUsuarioRepository.save(roleUsuario);
    }

}
