package com.example.demo.controller;

import com.example.demo.model.UsuarioModel;
import com.example.demo.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
//    @Autowired
    UsuarioService usuarioService;

    public UsuarioController(UsuarioService services) {
        this.usuarioService = services;
    }

    @PostMapping("/novo")
    public @ResponseBody String criarUsuarioString() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome("Novo nome");
        usuario.setSenha("78910");
        usuarioService.salvarUsuario(usuario);
        return "Usuário gravado com sucesso";
    }
    
//    @RequestMapping(method=RequestMethod.POST, value="/salvar", consumes=MediaType.APPLICATION_JSON_VALUE)
//    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuario){
//        return usuarioService.salvarUsuario(usuario);
//    }

    @PostMapping("/gravar")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel create(@RequestBody UsuarioModel usuario) {
        return usuarioService.salvarUsuario(usuario);
    }
    
    @GetMapping("/listar")
    public @ResponseBody Iterable<UsuarioModel> listaUsuarioModels() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/listar/{id}")
    public @ResponseBody ResponseEntity<UsuarioModel> listaUmUsuarioModel(@PathVariable("id") Long id) throws Exception {
        ResponseEntity usu = ResponseEntity.ok(usuarioService
        .listarUmUsuario(id));

        return usu;
    }
}