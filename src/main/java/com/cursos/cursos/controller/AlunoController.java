package com.cursos.cursos.controller;

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
    public ResponseEntity<String> promoverParaPremium(@RequestBody Aluno aluno) {
        return alunoService.promoverParaPremium(aluno);
    }

    @PostMapping("/inscrever-projeto")
    public ResponseEntity<String> inscreverEmProjeto(@RequestBody Aluno aluno, @RequestParam Long projetoId) {
        Projeto projeto = new Projeto(projetoId, "Nome do Projeto Exemplo"); // Criando um projeto com o ID fornecido
        alunoService.inscreverEmProjeto(aluno, projeto);
        return ResponseEntity.ok("Aluno inscrito no projeto");
    }

    @PostMapping("/finalizar-projeto")
    public ResponseEntity<String> finalizarProjeto(@RequestBody Aluno aluno, @RequestParam Long projetoId) {
        Projeto projeto = new Projeto(projetoId, "Nome do Projeto Exemplo"); // Criando um projeto com o ID fornecido
        alunoService.finalizarProjeto(aluno, projeto);
        return ResponseEntity.ok("Projeto finalizado e moedas adicionadas");
    }
}
