package br.com.caiozanchetta.reservas.services;

import br.com.caiozanchetta.reservas.model.Reserva;
import br.com.caiozanchetta.reservas.model.StatusReserva;
import br.com.caiozanchetta.reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva agendar(Reserva reserva) {
        reserva.validarReserva(); // Chama sua lógica de data inicio < fim

        // 1. Verificar conflito
        List<Reserva> conflitos = reservaRepository.findBySalaIdAndStatusAndInicioBeforeAndFimAfter(
                reserva.getSala().getId(),
                StatusReserva.ATIVA,
                reserva.getFim(),
                reserva.getInicio()
        );

        if (!conflitos.isEmpty()) {
            throw new RuntimeException("A sala já está reservada para este período!");
        }

        reserva.setStatus(StatusReserva.ATIVA); // Garante que nasce ATIVA
        return reservaRepository.save(reserva);
    }
}
