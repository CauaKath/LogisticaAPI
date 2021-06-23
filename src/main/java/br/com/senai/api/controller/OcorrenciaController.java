package br.com.senai.api.controller;

import br.com.senai.api.assembler.OcorrenciaAssembler;
import br.com.senai.api.model.OcorrenciaDTO;
import br.com.senai.api.model.input.OcorrenciaInputDTO;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Ocorrencia;
import br.com.senai.domain.service.EntregaService;
import br.com.senai.domain.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencia")
public class OcorrenciaController {

    private EntregaService entregaService;
    private OcorrenciaService ocorrenciaService;

    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrarOcorrencia(
            @PathVariable long entregaId,
            @Valid @RequestBody OcorrenciaInputDTO ocorrenciaInput
    ) {
        Ocorrencia ocorrencia = ocorrenciaService.registrarOcorrencia(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrencia);
    }

    @GetMapping
    public List<OcorrenciaDTO> listarOcorrencias(@PathVariable long entregaId) {
        Entrega entrega = entregaService.buscaEntrega(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
