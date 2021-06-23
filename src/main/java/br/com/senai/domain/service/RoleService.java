package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {

    private RoleRepository roleRepository;

    private RoleAssembler roleAssembler;

    @Transactional
    public Role cadastrarRole(Role role) {
        return roleRepository.save(role);
    }

    public List<RoleDTO> listar() {
        return roleAssembler.toCollectionModel(roleRepository.findAll());
    }

}
