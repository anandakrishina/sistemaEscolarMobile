package com.krishina.suapkrishina;

public class Aluno {
    private String nome;
    private int idade;
    private double nota1, nota2, nota3;

    public Aluno(String nome, int idade, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNome() {
        return nome;
    }


    public int getIdade() {
        return idade;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }

    public double calculaMedia(){
                return (nota1 + nota2 + nota3) / 3;
    }

    public String verificaSituacao() {
        return calculaMedia() >= 6 ? "Aprovado" : "Reprovado";
    }

}
