package br.com.senai.domain.service;

import br.com.senai.domain.exception.TrataException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Pessoa> editarPessoa(long pessoaId, Pessoa pessoa) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }

        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(pessoa);
    }

    @Transactional
    public ResponseEntity<Pessoa> removerPessoa(long pessoaId) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }

        pessoaRepository.deleteById(pessoaId);

        return ResponseEntity.noContent().build();
    }

}
