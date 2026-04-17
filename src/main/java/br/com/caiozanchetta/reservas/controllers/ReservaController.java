package br.com.caiozanchetta.reservas.controllers;

import br.com.caiozanchetta.reservas.model.Reserva;
import br.com.caiozanchetta.reservas.repository.ReservaRepository;
import br.com.caiozanchetta.reservas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return reservaService.agendar(reserva);
    }
}
