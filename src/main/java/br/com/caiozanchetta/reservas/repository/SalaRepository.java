package br.com.caiozanchetta.reservas.repository;

import br.com.caiozanchetta.reservas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}