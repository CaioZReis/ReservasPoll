package br.com.caiozanchetta.reservas.repository;

import br.com.caiozanchetta.reservas.model.Reserva;
import br.com.caiozanchetta.reservas.model.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Busca se existe alguma reserva para a mesma sala que se sobreponha ao horário solicitado e que não esteja CANCELADA
    List<Reserva> findBySalaIdAndStatusAndInicioBeforeAndFimAfter(Long salaId, StatusReserva status, LocalDateTime fim, LocalDateTime inicio);
}