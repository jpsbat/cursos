package com.cursos.cursos.dto;

public class ProjetoDTO {

    private Long id;
    private String nome;
    private boolean concluido;

    public ProjetoDTO() {
    }

    public ProjetoDTO(Long id, String nome, boolean concluido) {
        this.id = id;
        this.nome = nome;
        this.concluido = concluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
