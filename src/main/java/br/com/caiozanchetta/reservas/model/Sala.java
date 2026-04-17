package br.com.caiozanchetta.reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private int capacidade;
    private boolean ativa = true;

    protected Sala() {

    }

    public Sala(String nome, int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser positiva.");
        }
        this.nome = nome;
        this.capacidade = capacidade;
        this.ativa = true;
    }
}
