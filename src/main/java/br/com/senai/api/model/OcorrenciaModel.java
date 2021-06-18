package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OcorrenciaModel {

    private long id;
    private String descricao;
    private LocalDateTime dataRegistro;

}
