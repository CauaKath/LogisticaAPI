package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class EntregaInputDTO {

    @Valid
    @NotNull
    private RemetenteInputDTO remetente;

    @Valid
    @NotNull
    private DestinatarioInputDTO destinatario;

    @NotNull
    private BigDecimal taxa;

}
