package br.com.senai.domain.service;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.domain.exception.TrataException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;

    @Transactional // Rollback nos dados
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
//        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getUsuario().getEmail())
//                .isPresent();
//
//        if(emailValidation) {
//            throw new TrataException("Já existe uma pessoa com este e-mail cadastrado.");
//        }

        return pessoaRepository.save(pessoa);
    }

    public List<PessoaDTO> listar() {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    public List<PessoaDTO> listarPorNome(String pessoaNome) {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNome(pessoaNome));
    }

    public List<PessoaDTO> listarPorNomeContaining(String nomeContaining) {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNomeContaining(nomeContaining));
    }

    public ResponseEntity<PessoaDTO> buscarPorId(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .map(pessoa -> {
                    return ResponseEntity.ok(pessoaAssembler.toModel(pessoa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public Pessoa editarPessoa(Pessoa pessoa, long pessoaId) {
        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);
        return pessoa;
    }

    @Transactional
    public void removerPessoa(long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa buscarRemetente(long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new TrataException("Pessoa não encontrada"));
    }

}
