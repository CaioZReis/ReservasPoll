package br.com.caiozanchetta.reservas.model;

public class Usuário {
    private Long id;
    private String nome;
    private String email;

    public void Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
