package com.cursos.cursos.repository;

import com.cursos.cursos.entity.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AlunoRepositorySpringBootTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    void deveSalvarERecuperarAlunoComSpringBootTest() {
        Aluno aluno = new Aluno("Ana", 10);
        aluno = alunoRepository.save(aluno);

        Optional<Aluno> alunoEncontrado = alunoRepository.findById(aluno.getId());
        assertTrue(alunoEncontrado.isPresent());
        assertEquals("Ana", alunoEncontrado.get().getNome());
    }
}
