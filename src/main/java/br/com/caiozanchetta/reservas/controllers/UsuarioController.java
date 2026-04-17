package br.com.caiozanchetta.reservas.controllers;

import br.com.caiozanchetta.reservas.model.Usuario;
import br.com.caiozanchetta.reservas.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario criar(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}