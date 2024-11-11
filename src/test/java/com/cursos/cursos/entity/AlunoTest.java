package com.cursos.cursos.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveAdicionarMoedasAoAluno() {
        Aluno aluno = new Aluno("Ana", 10);
        aluno.adicionarMoedas(5);
        assertEquals(5, aluno.getMoedas());
    }

    @Test
    void deveDefinirAlunoComoPremium() {
        Aluno aluno = new Aluno("Carlos", 12);
        aluno.setPremium(true);
        assertTrue(aluno.isPremium());
    }

    @Test
    void deveDefinirVoucherParaAluno() {
        Aluno aluno = new Aluno("João", 12);
        Voucher voucher = new Voucher("VOUCHER123");
        aluno.setVoucher(voucher);
        assertEquals(voucher, aluno.getVoucher());
    }
}
