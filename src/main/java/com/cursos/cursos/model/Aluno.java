package com.cursos.cursos.model;

public class Aluno {
    private String nome;
    private int cursosConcluidos;
    private boolean isPremium;
    private boolean recebeuVoucher;
    private int moedas;

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.isPremium = false;
        this.recebeuVoucher = false;
        this.moedas = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public boolean recebeuVoucher() {
        return recebeuVoucher;
    }

    public void setRecebeuVoucher(boolean recebeuVoucher) {
        this.recebeuVoucher = recebeuVoucher;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }
}
