package com.cursos.cursos.model;

import java.time.LocalDate;

public class Voucher {
    private Long id;
    private LocalDate dataEmissao;
    private boolean usado;

    public Voucher(Long id) {
        this.id = id;
        this.dataEmissao = LocalDate.now();
        this.usado = false;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}
