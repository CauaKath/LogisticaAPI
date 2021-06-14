package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinatarioModel {

    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

}
