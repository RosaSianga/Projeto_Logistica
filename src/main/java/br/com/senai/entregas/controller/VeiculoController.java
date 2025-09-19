package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.VeiculoRepository;
import br.com.senai.entregas.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoRepository repo, VeiculoService veiculoService) {
        veiculoRepository = repo;
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/id")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoveiculo = veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.ok(novoveiculo);
    }

    @PutMapping("/id")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        Veiculo veiculoExistente = veiculoService.atualizarVeiculo(id, veiculo);
        if (veiculoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculoExistente);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Veiculo> deletarVeiculo(@PathVariable Integer id) {
        Veiculo veiculoExistente = veiculoService.deletarVeiculo(id);
        if (veiculoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculoExistente);
    }
}
