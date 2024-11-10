package com.cursos.cursos.entity;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Voucher {

    private String codigo;

    protected Voucher() {}

    public Voucher(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código do voucher não pode ser nulo ou vazio");
        }
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return Objects.equals(codigo, voucher.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
