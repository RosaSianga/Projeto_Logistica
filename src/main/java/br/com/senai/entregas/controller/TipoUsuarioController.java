package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import br.com.senai.entregas.service.TipoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) {
        tipoUsuarioService = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarUsuarios() {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioService.listarTiposUsuario();
        return ResponseEntity.ok(tipoUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarPorId(@PathVariable Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioService.consultarTipoPorId(id);
        if (tipoUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoUsuario);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrar(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoNovo = tipoUsuarioService.cadastrarTipoUsuario(tipoUsuario);
        if (tipoNovo == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tipoNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> alterarTipo(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoExistente = tipoUsuarioService.consultarTipoPorId(id);
        if (tipoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoUsuario> deletarTipo(@PathVariable Integer id) {
        TipoUsuario tipoExistente = tipoUsuarioService.consultarTipoPorId(id);
        if (tipoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoExistente);
    }

}
