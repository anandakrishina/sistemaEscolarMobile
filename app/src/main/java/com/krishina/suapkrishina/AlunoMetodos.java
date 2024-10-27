package com.krishina.suapkrishina;

import java.util.ArrayList;
import java.util.List;

public class AlunoMetodos {
    List<Aluno>alunoList = new ArrayList<>();

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public double mediaTurma(){
        double mediaTurma = 0;
        for (Aluno aluno : alunoList) {
            mediaTurma += aluno.calculaMedia();
        }
        mediaTurma = mediaTurma/alunoList.size();
        return mediaTurma;
        //test
        //System.out.println(mediaTurma);
    }

    public String verificaAlunoMaisVelho(){
        int idade = Integer.MIN_VALUE;
        String alunoMaisVelho = null;


        for (Aluno aluno : alunoList) {
            if (idade < aluno.getIdade()){
                idade = aluno.getIdade();
                alunoMaisVelho = aluno.getNome();
            }
        }
        return alunoMaisVelho;
    }

    public String verificaAlunoMaisNovo(){
        int idade = Integer.MAX_VALUE;
        String alunoMaisNovo = null;

        for (Aluno aluno : alunoList) {
            if (idade > aluno.getIdade()){
                idade = aluno.getIdade();
                alunoMaisNovo = aluno.getNome();
            }
        }
        return alunoMaisNovo;
    }

    public String mostrarRelatorioGeral() {
        String relatorio = "----ESTUDANTES----\n\n";
        for (Aluno aluno : alunoList) {
            relatorio += aluno.getNome().toUpperCase() + " - Média = " + String.format("%.2f",aluno.calculaMedia()) + " - "+ aluno.verificaSituacao() + "\n";
        }
        return relatorio;
    }

    public void cadastrarAluno(String nome, int idade, double nota1Valor, double nota2Valor, double nota3Valor) {
        Aluno aluno = new Aluno(nome, idade, nota1Valor, nota2Valor, nota3Valor);
        alunoList.add(aluno);
    }
}
