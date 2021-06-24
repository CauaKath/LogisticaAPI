package br.com.senai.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RoleUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long usuarios_id;

    private String role_nome_role;

}
