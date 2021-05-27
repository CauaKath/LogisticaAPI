package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")
    public List<Pessoa> listar() {
        Pessoa pessoa1 = new Pessoa(
                1L,
                "Cauã",
                "caua@gmail.com",
                "(47)98829-1291"
        );

        Pessoa pessoa2 = new Pessoa(
                2L,
                "Miriam",
                "miriam@gmail.com",
                "(47)92932-2321"
        );

        return Arrays.asList(pessoa1, pessoa2);
    }
}
