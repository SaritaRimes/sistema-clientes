package com.projeto.padroesprojeto.service;

import com.projeto.padroesprojeto.model.Cliente;
import com.projeto.padroesprojeto.model.form.ClienteForm;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    Cliente inserir(ClienteForm clienteForm);
    Cliente atualizar(Long id, ClienteForm clienteForm);
    void deletar(Long id);
}
