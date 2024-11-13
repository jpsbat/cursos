package com.cursos.cursos.controller;

import com.cursos.cursos.dto.AlunoDTO;
import com.cursos.cursos.dto.FinalizarProjetoRequest;
import com.cursos.cursos.dto.ProjetoDTO;
import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.model.Projeto;
import com.cursos.cursos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/promover")
    public ResponseEntity<String> promoverParaPremium(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getCursosConcluidos());
        return alunoService.promoverParaPremium(aluno);
    }

    @PostMapping("/finalizar-projeto")
    public ResponseEntity<String> finalizarProjeto(@RequestBody FinalizarProjetoRequest request) {
        AlunoDTO alunoDTO = request.getAluno();
        ProjetoDTO projetoDTO = request.getProjeto();
        Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getCursosConcluidos());
        Projeto projeto = new Projeto(projetoDTO.getId(), projetoDTO.getNome());
        
        alunoService.finalizarProjeto(aluno, projeto);
        return ResponseEntity.ok("Projeto finalizado e moedas adicionadas");
    }
}
