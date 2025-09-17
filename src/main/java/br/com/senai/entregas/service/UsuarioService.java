package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository repo) {
        usuarioRepository = repo;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario consultarUsuarioPorId(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado){
        Usuario usuarioExistente = consultarUsuarioPorId(id);
        if(usuarioExistente == null){
            return null;
        }

        usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario deletarUsuario (Integer id){
        Usuario usuarioExistente = consultarUsuarioPorId(id);
        if(usuarioExistente == null){
            return null;
        }
        usuarioRepository.delete(usuarioExistente);
        return usuarioExistente;
    }

}
