package com.cursos.cursos.repository;

import com.cursos.cursos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Aluno_Repository extends JpaRepository<Aluno, Long> {
}
