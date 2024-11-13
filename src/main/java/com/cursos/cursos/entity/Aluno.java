package com.cursos.cursos.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int cursosConcluidos;

    private boolean isPremium;

    private int moedas;

    @Embedded
    private Voucher voucher;

    public Aluno() {}

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.isPremium = false;
        this.moedas = 0;
    }

    // Getters e Setters

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

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int getMoedas() {
        return moedas;
    }

    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
