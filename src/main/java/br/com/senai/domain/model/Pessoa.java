package br.com.senai.domain.model;

import br.com.senai.domain.ValidationGroups;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Pessoa {

    @NotNull(groups = ValidationGroups.ClienteId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    @Size(max = 80)
    String nome;

    @NotBlank
    @Email
    @Size(min = 5)
    String email;

    @NotBlank
    @Size(min = 14, max = 14)
    String telefone;
}
