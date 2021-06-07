package br.com.senai.domain.service;

import br.com.senai.domain.exception.TrataException;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.StatusEntrega;
import br.com.senai.domain.repository.EntregaRepository;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private PessoaService pessoaService;
    private EntregaRepository entregaRepository;

    public Entrega solicitar(Entrega entrega) {
        Pessoa pessoa = pessoaService.buscar(entrega.getPessoa().getId());
        entrega.setPessoa(pessoa);

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setData_pedido(LocalDateTime.now());
        entrega.setData_finalizacao(null);

        return entregaRepository.save(entrega);
    }
}
