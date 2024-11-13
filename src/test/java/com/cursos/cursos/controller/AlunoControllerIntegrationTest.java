package com.cursos.cursos.controller;

import com.cursos.cursos.dto.AlunoDTO;
import com.cursos.cursos.dto.FinalizarProjetoRequest;
import com.cursos.cursos.dto.ProjetoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class AlunoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void devePromoverAlunoParaPremium() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João Silva");
        alunoDTO.setCursosConcluidos(12);

        mockMvc.perform(post("/api/aluno/promover")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Aluno promovido a Premium e recebeu um voucher!"));
    }

    @Test
    void deveFinalizarProjetoComSucesso() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João Silva");
        alunoDTO.setCursosConcluidos(12);

        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.setId(1L);
        projetoDTO.setNome("Projeto Exemplo");

        FinalizarProjetoRequest request = new FinalizarProjetoRequest();
        request.setAluno(alunoDTO);
        request.setProjeto(projetoDTO);

        mockMvc.perform(post("/api/aluno/finalizar-projeto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Projeto finalizado e moedas adicionadas"));
    }

}
