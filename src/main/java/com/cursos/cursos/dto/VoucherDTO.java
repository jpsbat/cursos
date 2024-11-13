package com.cursos.cursos.dto;

import java.time.LocalDate;

public class VoucherDTO {

    private Long id;
    private LocalDate dataEmissao;
    private boolean usado;

    public VoucherDTO() {
    }

    public VoucherDTO(Long id, LocalDate dataEmissao, boolean usado) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.usado = usado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}
