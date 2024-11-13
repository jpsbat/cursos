package com.cursos.cursos.tests;

import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.model.Projeto;
import com.cursos.cursos.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
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
        Projeto projeto = new Projeto(1L, "Projeto Exemplo");
        
        alunoService.promoverParaPremium(aluno);
        alunoService.inscreverEmProjeto(aluno, projeto);
        assertTrue(true);
    }

    @Test
    void givenParticipeiDeProjetoWhenConcluiThenReceboMoedas() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        Projeto projeto = new Projeto(1L, "Projeto Exemplo");
        
        alunoService.inscreverEmProjeto(aluno, projeto);
        alunoService.finalizarProjeto(aluno, projeto);
        assertEquals(3, aluno.getMoedas());
    }

    @Test
    void givenAlunoPremiumWhenNovosProjetosDisponiveisThenReceboNotificacao() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        alunoService.promoverParaPremium(aluno);
        assertTrue(alunoService.notificarProjetosReais(aluno));
    }
}
