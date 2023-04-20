package com.projeto.padroesprojeto.controller;

import com.projeto.padroesprojeto.model.Endereco;
import com.projeto.padroesprojeto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public Iterable<Endereco> buscarTodos() {
        return enderecoService.buscarTodos();
    }
}
