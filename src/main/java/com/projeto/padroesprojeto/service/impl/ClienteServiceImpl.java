package com.projeto.padroesprojeto.service.impl;

import com.projeto.padroesprojeto.model.Cliente;
import com.projeto.padroesprojeto.model.Endereco;
import com.projeto.padroesprojeto.model.form.ClienteForm;
import com.projeto.padroesprojeto.repository.ClienteRepository;
import com.projeto.padroesprojeto.repository.EnderecoRepository;
import com.projeto.padroesprojeto.service.ClienteService;
import com.projeto.padroesprojeto.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente inserir(ClienteForm clienteForm) {
        Cliente cliente = new Cliente(clienteForm.getNome());
        Endereco endereco = buscarEnderecoSalvando(clienteForm.getCep());
        cliente.setEndereco(endereco);

        if (cliente.getEndereco().getCep() != null && !cliente.getEndereco().getCep().isEmpty()) {
            cliente.setComplementoEndereco(clienteForm.getComplementoEndereco());
            cliente.setReferenciaEndereco(clienteForm.getReferencia());
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Long id, ClienteForm clienteForm) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            Endereco endereco = buscarEnderecoSalvando(clienteForm.getCep());

            String nomeForm = clienteForm.getNome();
            String complementoForm = clienteForm.getComplementoEndereco();
            String referenciaForm = clienteForm.getReferencia();

            if (nomeForm != null && !nomeForm.isEmpty() && !nomeForm.equals(cliente.getNome())) {
                cliente.setNome(nomeForm);
            }

            if (endereco.getCep() != null && !endereco.getCep().isEmpty()) {
                if (cliente.getEndereco() == null) {
                    cliente.setEndereco(endereco);
                } else if (!cliente.getEndereco().getCep().equals(endereco.getCep()))
                    cliente.setEndereco(endereco);
            }

            if (complementoForm != null
                    && !complementoForm.isEmpty()
                    && !complementoForm.equals(cliente.getComplementoEndereco()))
                cliente.setComplementoEndereco(complementoForm);

            if (referenciaForm != null
                    && !referenciaForm.isEmpty()
                    && !referenciaForm.equals(cliente.getReferenciaEndereco()))
                cliente.setReferenciaEndereco(referenciaForm);

            clienteRepository.save(cliente);

            return cliente;
        } else
            return null;
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Endereco buscarEnderecoSalvando(String cep) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(cep);

        if (enderecoOptional.isPresent())
            return enderecoOptional.get();
        else {
            Endereco novoEndereco = viaCepService.consultaCep(cep);

            if (novoEndereco != null) {
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
            } else
                return new Endereco();
        }
    }
}
