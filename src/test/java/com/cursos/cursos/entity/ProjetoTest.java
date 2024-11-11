package com.cursos.cursos.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjetoTest {

    @Test
    void deveCriarProjetoComNome() {
        Projeto projeto = new Projeto("Projeto Teste");
        assertEquals("Projeto Teste", projeto.getNome());
    }

    @Test
    void projetosComMesmoIdDevemSerIguais() {
        Projeto projeto1 = new Projeto(1L, "Projeto A");
        Projeto projeto2 = new Projeto(1L, "Projeto B");

        assertEquals(projeto1, projeto2);
        assertEquals(projeto1.hashCode(), projeto2.hashCode());
    }
}
