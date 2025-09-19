package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Entrega;
import br.com.senai.entregas.repository.EntregaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    //Listar
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    //Busca por ID
    public Entrega buscarEntregaPorId(Integer id) {
        return entregaRepository.findById(id).orElse(null);
    }

    //Cadastrar
    public Entrega cadastrarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    //Atualizar
    public Entrega atualizarEntrega(Integer id, Entrega entrega) {
        Entrega entregaExistente = buscarEntregaPorId(id);
        if (entregaExistente == null) {
            return null;
        }
        entregaExistente.setDescricaoProdudo(entrega.getDescricaoProdudo());
        entregaExistente.setStatus(entregaExistente.getStatus());
        entregaExistente.setEndereco(entrega.getEndereco());

        return entregaRepository.save(entrega);
    }

    //Deletar
    public Entrega deletarEntrega(Integer id) {
        Entrega entregaExistente = buscarEntregaPorId(id);
        if (entregaExistente == null) {
            return null;
        }
        entregaRepository.delete(entregaExistente);
        return entregaExistente;
    }
}
