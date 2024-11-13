package com.cursos.cursos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.model.Projeto;

class AlunoServiceTest {

    private AlunoService alunoService;
    private Aluno aluno;

    @BeforeEach
    void setUp() {
        alunoService = new AlunoService();
        aluno = new Aluno("João Silva", 10);
    }

    @Test
    void devePromoverAlunoParaPremiumQuandoCursosConcluidosSuficientes() {
        aluno.setCursosConcluidos(12);
        ResponseEntity<String> response = alunoService.promoverParaPremium(aluno);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(aluno.isPremium());
        assertTrue(aluno.recebeuVoucher());
        assertEquals(1, aluno.getVouchers().size());
    }

    @Test
    void naoDevePromoverAlunoParaPremiumQuandoCursosConcluidosInsuficientes() {
        ResponseEntity<String> response = alunoService.promoverParaPremium(aluno);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertFalse(aluno.isPremium());
    }

    @Test
    void deveAdicionarMoedasAoFinalizarProjeto() {
        Projeto projeto = new Projeto(1L, "Projeto Exemplo");
        alunoService.finalizarProjeto(aluno, projeto);

        assertTrue(projeto.isConcluido());
        assertEquals(3, aluno.getMoedas());
    }

    @Test
    void deveNotificarProjetosReaisParaAlunoPremium() {
        aluno.setPremium(true);
        assertTrue(alunoService.notificarProjetosReais(aluno));
    }
}
