package br.com.senai.api.model;

import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class EntregaDTO {

    private long id;

    private RemetenteDTO remetente;

    private DestinatarioDTO destinatario;

    private BigDecimal taxa;

    private LocalDateTime data_pedido;
    private LocalDateTime data_finalizacao;

    private StatusEntrega status;

}
