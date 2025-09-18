package br.com.senai.entregas.service;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository repo) {
        tipoUsuarioRepository = repo;
    }

    public List<TipoUsuario> listarTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario consultarTipoPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario tipoUsuario) {
        TipoUsuario tipoExixtente = consultarTipoPorId(id);
        if (tipoExixtente == null) {
            return null;
        }
        tipoExixtente.setDescricao(tipoUsuario.getDescricao());
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario deletarTipoUsuario(Integer id) {
        TipoUsuario tipoExixtente = consultarTipoPorId(id);
        if (tipoExixtente == null) {
            return null;
        }
        tipoUsuarioRepository.delete(tipoExixtente);
        return tipoExixtente;
    }
}

