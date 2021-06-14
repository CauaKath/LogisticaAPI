package br.com.senai.domain.service;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.model.DestinatarioModel;
import br.com.senai.api.model.EntregaModel;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.RemetenteModel;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.StatusEntrega;
import br.com.senai.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private PessoaService pessoaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    public Entrega solicitar(Entrega entrega) {
        Pessoa remetente = pessoaService.buscarRemetente(entrega.getRemetente().getId());
        entrega.setRemetente(remetente);

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setData_pedido(LocalDateTime.now());
        entrega.setData_finalizacao(null);

        return entregaRepository.save(entrega);
    }

    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    public ResponseEntity<EntregaModel> buscarPorId(long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    return ResponseEntity.ok(entregaAssembler.toModel(entrega));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
