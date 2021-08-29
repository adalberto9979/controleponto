package com.example.demo.service;

import com.example.demo.model.UsuarioModel;
import com.example.demo.respository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService (UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> listarUmUsuario(Long id) {
        Optional<UsuarioModel> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            return optional;
        } else {
            return Optional.empty();
        }
    }
    
    public UsuarioModel login(String nome) {
	  UsuarioModel usuario = usuarioRepository.findByNome(nome);
  	return usuario;
    }
}