package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Entrega;
import br.com.senai.entregas.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entrega")
public class EntregaController {

public final EntregaService entregaService;


    public EntregaController(EntregaService service) {
        entregaService = service;
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> listarTodos() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(Integer id) throws  Exception{
        Entrega entrega = entregaService.buscarEntregaPorId(id);
        return ResponseEntity.ok(entrega);
    }

    @PostMapping
    public ResponseEntity<Entrega> cadatrarEntrega(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaService.cadastrarEntrega(entrega);
        return ResponseEntity.ok(novaEntrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizarEntrega(@PathVariable Integer id, @RequestBody Entrega entrega) {
        Entrega entregaAtualizada = entregaService.atualizarEntrega(id, entrega);
        if  (entregaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entregaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Integer id) {
        Entrega entregaDeletada = entregaService.deletarEntrega(id);
        if (entregaDeletada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();

    }
}
