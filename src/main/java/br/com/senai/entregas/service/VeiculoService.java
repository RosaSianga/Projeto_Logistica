package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    public final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository repo) {
        veiculoRepository = repo;
    }

    //Listar
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    //Buscar pelo ID
    public Veiculo buscarVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    //Cadastrar novo
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    //Atualizar
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo) {
        Veiculo veiculoExistente = buscarVeiculoPorId(id);
        if (veiculoExistente == null) {
            return null;
        }
        veiculoExistente.setModelo(veiculo.getModelo());
        veiculoExistente.setTipo(veiculo.getTipo());
        veiculoExistente.setPlaca(veiculo.getPlaca());

        return veiculoRepository.save(veiculo);
    }

    //Deletar
    public Veiculo deletarVeiculo(Integer id) {
        Veiculo veiculo = buscarVeiculoPorId(id);
        if (veiculo == null) {
            return null;
        }
        veiculoRepository.delete(veiculo);
        return veiculo;
    }

}
