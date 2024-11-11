package com.cursos.cursos.repository;

import com.cursos.cursos.entity.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlunoRepositoryIntegrationTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    void deveSalvarAlunoNoBancoDeDados() {
        Aluno aluno = new Aluno("Maria", 5);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        assertNotNull(alunoSalvo.getId());
        assertEquals("Maria", alunoSalvo.getNome());
    }

    @Test
    void deveEncontrarAlunoPorId() {
        Aluno aluno = new Aluno("José", 7);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        Optional<Aluno> alunoEncontrado = alunoRepository.findById(alunoSalvo.getId());
        assertTrue(alunoEncontrado.isPresent());
        assertEquals("José", alunoEncontrado.get().getNome());
    }

    @Test
    void deveExcluirAlunoPorId() {
        Aluno aluno = new Aluno("Carlos", 3);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        alunoRepository.deleteById(alunoSalvo.getId());
        Optional<Aluno> alunoExcluido = alunoRepository.findById(alunoSalvo.getId());
        assertFalse(alunoExcluido.isPresent());
    }
}
