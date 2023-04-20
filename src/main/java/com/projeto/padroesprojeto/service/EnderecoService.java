package com.projeto.padroesprojeto.service;

import com.projeto.padroesprojeto.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService {
    Iterable<Endereco> buscarTodos();
}
