package br.com.senai.api.model.input;

import br.com.senai.api.model.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class PessoaInputDTO {

    @Valid
    @NotBlank
    private String nome;

    @NotNull
    private UsuarioDTO usuario;

    @Valid
    @NotBlank
    @Size(max = 14, min = 14)
    private String telefone;

}
