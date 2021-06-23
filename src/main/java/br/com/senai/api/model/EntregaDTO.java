package br.com.senai.api.model;

import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class EntregaModel {

    private long id;

    private RemetenteModel remetente;

    private DestinatarioModel destinatario;

    private BigDecimal taxa;

    private LocalDateTime data_pedido;
    private LocalDateTime data_finalizacao;

    private StatusEntrega status;

}
