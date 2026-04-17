package br.com.caiozanchetta.reservas.controllers ;

import br.com.caiozanchetta.reservas.model.Sala;
import br.com.caiozanchetta.reservas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> listar() {
        return salaRepository.findAll();
    }

    @PostMapping
    public Sala criar(@RequestBody Sala sala) {
        return salaRepository.save(sala);
    }
}