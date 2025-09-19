package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository repo) {
        enderecoRepository = repo;
    }

    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Integer id, Endereco endereco) {
        Endereco enderecoExistente = buscarEnderecoPorId(id);
        if (enderecoExistente == null) {
            return null;
        }
        return enderecoRepository.save(enderecoExistente);
    }

    public Endereco deletarEndereco(Integer id) {
        Endereco enderecoExistente = buscarEnderecoPorId(id);
        if (enderecoExistente == null) {
            return null;
        }
        enderecoRepository.delete(enderecoExistente);
        return enderecoExistente;
    }

}
