package com.cursos.cursos.tests;

import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlunoControllerTest {

    @Autowired
    private AlunoService alunoService;

    @Test
    void alunoPremiumRecebeVoucher() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        
        ResponseEntity<String> response = alunoService.promoverParaPremium(aluno);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(alunoService.verificarSeRecebeuVoucher(aluno));
    }

    @Test
    void alunoRecebeMoedasAposProjetoReal() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        
        alunoService.inscreverEmProjeto(aluno);
        alunoService.finalizarProjeto(aluno);
        
        assertEquals(3, aluno.getMoedas());
    }

    @Test
    void alunoRecebeNotificacaoParaProjetosReais() {
        Aluno aluno = new Aluno("Vinícius Ribeiro", 12);
        
        alunoService.promoverParaPremium(aluno);
        
        assertTrue(alunoService.notificarProjetosReais(aluno));
    }
}