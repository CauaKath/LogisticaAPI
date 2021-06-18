package br.com.senai.api.assembler;

import br.com.senai.api.model.OcorrenciaModel;
import br.com.senai.api.model.input.OcorrenciaInput;
import br.com.senai.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Ocorrencia toEntity(OcorrenciaInput ocorrenciaInput) {
        return modelMapper.map(ocorrenciaInput, Ocorrencia.class);
    }

}