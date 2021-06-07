package br.com.senai.domain.service;

import br.com.senai.domain.exception.TrataException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Transactional // Rollback nos dados
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail())
                .isPresent();

        if(emailValidation) {
            throw new TrataException("Já existe uma pessoa com este e-mail cadastrado.");
        }

        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void removerPessoa(long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa buscar(long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new TrataException("Pessoa não encontrada"));
    }

}
