package br.com.caiozanchetta.reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    protected Usuario() {

    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O email é obrigatório") @Email(message = "Email deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório") @Email(message = "Email deve ser válido") String email) {
        this.email = email;
    }
}