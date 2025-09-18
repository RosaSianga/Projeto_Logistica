package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Controle de Usuários", description = "Operações relacionadas ao usuário")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service) {
        usuarioService = service;
    }

    @GetMapping
    @Operation(
            summary = "Lista de usuários"
    )
    ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consultar usuário pelo Identificador(ID)"
    )
    ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.consultarUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Operation(
            summary = "Cadastrar um novo usuário"
    )
    ResponseEntity<Usuario> cadastrarUsuario (@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar um usuário"
    )
    ResponseEntity<Usuario> atualizarUsuario (@PathVariable Integer id,  @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        if (usuarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar um usuário"
    )
    ResponseEntity<?> deletarUsuario (@PathVariable Integer id) {
        Usuario usuarioDeletado = usuarioService.deletarUsuario(id);
        if (usuarioDeletado == null) {
            return ResponseEntity.badRequest().body("Não encontrado");
        }
        return ResponseEntity.ok(usuarioDeletado);
    }
}
