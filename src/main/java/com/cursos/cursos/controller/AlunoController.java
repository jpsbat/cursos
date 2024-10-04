package com.cursos.cursos.controller;

import com.cursos.cursos.model.Aluno;
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
    public ResponseEntity<String> inscreverEmProjeto(@RequestBody Aluno aluno) {
        alunoService.inscreverEmProjeto(aluno);
        return ResponseEntity.ok("Aluno inscrito no projeto");
    }

    @PostMapping("/finalizar-projeto")
    public ResponseEntity<String> finalizarProjeto(@RequestBody Aluno aluno) {
        alunoService.finalizarProjeto(aluno);
        return ResponseEntity.ok("Projeto finalizado e moedas adicionadas");
    }
}
