package br.com.senai.domain.service;

import br.com.senai.domain.exception.TrataException;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EntregaService {

    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizarEntrega(long entregaId) {
        Entrega entrega = buscaEntrega(entregaId);

        entrega.finalizarEntrega();

        entregaRepository.save(entrega);
    }

    public Entrega buscaEntrega(long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new TrataException("Entrega não encontrada"));
    }

}
