package com.cursos.cursos.dto;

import java.util.List;

public class AlunoDTO {

    private String nome;
    private int cursosConcluidos;
    private boolean isPremium;
    private boolean recebeuVoucher;
    private int moedas;
    private List<VoucherDTO> vouchers;
    private List<ProjetoDTO> projetos;

    public AlunoDTO() {
    }

    public AlunoDTO(String nome, int cursosConcluidos, boolean isPremium, boolean recebeuVoucher, int moedas,
                    List<VoucherDTO> vouchers, List<ProjetoDTO> projetos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.isPremium = isPremium;
        this.recebeuVoucher = recebeuVoucher;
        this.moedas = moedas;
        this.vouchers = vouchers;
        this.projetos = projetos;
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

    public boolean isRecebeuVoucher() {
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

    public List<VoucherDTO> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<VoucherDTO> vouchers) {
        this.vouchers = vouchers;
    }

    public List<ProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoDTO> projetos) {
        this.projetos = projetos;
    }
}
