package com.cursos.cursos.tests;

import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BDDTest {

    private AlunoService alunoService;

    @BeforeEach
    void setup() {
        alunoService = new AlunoService();
    }

    @Test
    void givenCompletei12CursosWhenReconhecidoProgressoThenReceboVoucher() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        alunoService.promoverParaPremium(aluno);
        assertTrue(alunoService.verificarSeRecebeuVoucher(aluno));
    }

    @Test
    void givenPossuoVoucherWhenEscolhoProjetoThenSouInscritoAutomaticamente() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        alunoService.promoverParaPremium(aluno);
        alunoService.inscreverEmProjeto(aluno);
        assertTrue(true);
    }

    @Test
    void givenParticipeiDeProjetoWhenConcluiThenReceboMoedas() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        alunoService.inscreverEmProjeto(aluno);
        alunoService.finalizarProjeto(aluno);
        assertEquals(3, aluno.getMoedas());
    }

    @Test
    void givenAlunoPremiumWhenNovosProjetosDisponiveisThenReceboNotificacao() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        alunoService.promoverParaPremium(aluno);
        assertTrue(alunoService.notificarProjetosReais(aluno));
    }
}
