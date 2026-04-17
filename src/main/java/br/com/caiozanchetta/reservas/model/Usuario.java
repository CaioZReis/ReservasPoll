package br.com.caiozanchetta.reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    protected Usuario() {

    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}