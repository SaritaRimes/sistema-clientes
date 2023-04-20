package com.projeto.padroesprojeto.service.impl;

import com.projeto.padroesprojeto.model.Endereco;
import com.projeto.padroesprojeto.repository.EnderecoRepository;
import com.projeto.padroesprojeto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }
}
