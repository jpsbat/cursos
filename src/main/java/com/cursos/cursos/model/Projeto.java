package com.cursos.cursos.model;

public class Projeto {
    private Long id;
    private String nome;
    private boolean concluido;

    public Projeto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.concluido = false;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
