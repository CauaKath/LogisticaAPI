package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.input.RoleInputDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    private RoleAssembler roleAssembler;

    @PostMapping
    public RoleDTO cadastrarRole(@Valid @RequestBody RoleInputDTO roleInputDTO) {
        Role novaRole = roleAssembler.toEntity(roleInputDTO);
        Role role = roleService.cadastrarRole(novaRole);

        return roleAssembler.toModel(role);
    }

    @GetMapping
    public List<RoleDTO> listar() {
        return roleService.listar();
    }

}
