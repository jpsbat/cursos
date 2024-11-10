package com.cursos.cursos.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int cursosConcluidos;
    private boolean isPremium;
    private boolean recebeuVoucher;
    private int moedas;
    private List<Voucher> vouchers;
    private List<Projeto> projetos;

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.isPremium = false;
        this.recebeuVoucher = false;
        this.moedas = 0;
        this.vouchers = new ArrayList<>();
        this.projetos = new ArrayList<>();
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

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void adicionarVoucher(Voucher voucher) {
        this.vouchers.add(voucher);
    }

    public void inscreverEmProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }
}
