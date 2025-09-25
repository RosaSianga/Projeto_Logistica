package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo,
                          PasswordEncoder passwordEncoder) {

        usuarioRepository = repo;
        this.passwordEncoder = passwordEncoder;;
    }

    public List<Usuario> listarUsuarios() {

        return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "usuarioId"));
    }

    public Usuario cadastrarUsuario(Usuario usuario) {

        // Pega a senha em texto plano e gera o hash
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());

        // Substitui a senha original pelo hash gerado
        usuario.setSenha(senhaCriptografada);

        // Salva o usuário no banco com a senha já em formato de hash
        return usuarioRepository.save(usuario);
    }

    public Usuario consultarUsuarioPorId(Integer id) {

        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = consultarUsuarioPorId(id);
        if (usuarioExistente == null) {
            return null;
        }

        usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario deletarUsuario(Integer id) {
        Usuario usuarioExistente = consultarUsuarioPorId(id);
        if (usuarioExistente == null) {
            return null;
        }
        usuarioRepository.delete(usuarioExistente);
        return usuarioExistente;
    }

}
