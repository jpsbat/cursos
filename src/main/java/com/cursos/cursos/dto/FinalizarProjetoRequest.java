package com.cursos.cursos.dto;

public class FinalizarProjetoRequest {
    private AlunoDTO aluno;
    private ProjetoDTO projeto;

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public ProjetoDTO getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoDTO projeto) {
        this.projeto = projeto;
    }
}
