package br.com.caiozanchetta.reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Sala sala;

    @ManyToOne
    @NotNull
    private Usuario usuario;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    protected Reserva() {}

    public Reserva(Sala sala, Usuario usuario, LocalDateTime inicio, LocalDateTime fim) {
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = fim;
        this.status = StatusReserva.ATIVA;
        validarReserva();
    }

    public void validarReserva() {
        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("Datas de início e fim são obrigatórias.");
        }
        if (!inicio.isBefore(fim)) {
            throw new IllegalArgumentException("A data de início deve ser anterior à data de fim.");
        }
    }
    // Precisarei quando implementar a Service
//    public boolean conflitaCom(LocalDateTime outroInicio, LocalDateTime outroFim) {
//        if (this.status == StatusReserva.CANCELADA) return false;
//        return this.inicio.isBefore(outroFim) && outroInicio.isBefore(this.fim);
//    }
//
    public void cancelar() {
        if (this.status == StatusReserva.CANCELADA) {
            throw new IllegalStateException("Reserva já está cancelada.");
        }
        this.status = StatusReserva.CANCELADA;
    }
}