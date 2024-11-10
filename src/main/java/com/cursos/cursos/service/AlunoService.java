package com.cursos.cursos.service;

import com.cursos.cursos.model.Aluno;
import com.cursos.cursos.model.Projeto;
import com.cursos.cursos.model.Voucher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    public ResponseEntity<String> promoverParaPremium(Aluno aluno) {
        if (aluno.getCursosConcluidos() >= 12) {
            aluno.setPremium(true);
            aluno.setRecebeuVoucher(true);
            aluno.adicionarVoucher(new Voucher(1L));
            return new ResponseEntity<>("Aluno promovido a Premium e recebeu um voucher!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Aluno ainda não completou os cursos necessários", HttpStatus.BAD_REQUEST);
    }

    public boolean verificarSeRecebeuVoucher(Aluno aluno) {
        return aluno.recebeuVoucher();
    }

    public void inscreverEmProjeto(Aluno aluno, Projeto projeto) {
        aluno.inscreverEmProjeto(projeto);
    }

    public void finalizarProjeto(Aluno aluno, Projeto projeto) {
        projeto.setConcluido(true);
        aluno.setMoedas(aluno.getMoedas() + 3);
    }

    public boolean notificarProjetosReais(Aluno aluno) {
        return aluno.isPremium();
    }
}
