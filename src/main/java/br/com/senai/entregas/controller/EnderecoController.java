package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService service) {
        enderecoService = service;
    }

    @GetMapping
    ResponseEntity<List<Endereco>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEndereco();
        return ResponseEntity.ok().body(enderecos);
    }

    @GetMapping("/{id}")
    ResponseEntity<Endereco> buscarEnderecoPorId(Integer id) {
        return ResponseEntity.ok().body(enderecoService.buscarEnderecoPorId(id));
    }

    @PostMapping
    ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoNovo = enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.ok().body(enderecoNovo);
    }

    @PutMapping("/{id}")
    ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
        Endereco enderecoExistente = enderecoService.atualizarEndereco(id, endereco);
        if (enderecoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecoExistente);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Endereco> deletarEndereco(@PathVariable Integer id) {
        Endereco enderecoExistente = enderecoService.deletarEndereco(id);
        if (enderecoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecoExistente);

    }
}
