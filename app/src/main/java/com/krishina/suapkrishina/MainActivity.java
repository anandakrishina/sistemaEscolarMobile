package com.krishina.suapkrishina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_age;
    private EditText editText_nota1;
    private EditText editText_nota2;
    private EditText editText_nota3;
    private Button button_click;
    private Button button_adicionar;
    private List<Aluno> alunoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.editText_name);
        editText_age = findViewById(R.id.editText_age);
        editText_nota1 = findViewById(R.id.editText_nota1);
        editText_nota2 = findViewById(R.id.editText_nota2);
        editText_nota3 = findViewById(R.id.editText_nota3);
        button_click = findViewById(R.id.button_calcular);
        button_adicionar = findViewById(R.id.button_cadastrar);

        alunoList = new ArrayList<>();

        button_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroAluno();
                mediaTurma();
                editText_name.setText("");
                editText_age.setText("");
                editText_nota1.setText("");
                editText_nota2.setText("");
                editText_nota3.setText("");

            }
        });

        button_click.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado();
            }
        }));

    }

    private void mostraResultado() {
        double media = mediaTurma();
        String alunoMaisVelho = verificaAlunoMaisVelho();
        String alunoMaisNovo = verificaAlunoMaisNovo();
        String mostrarMediaTurma = String.format("Média da turma: %.2f", media);
        String mostrarAlunoMaisVelho = String.format("Aluno(a) mais velho(a): %s", alunoMaisVelho);
        String mostrarAlunoMaisNovo = String.format("Aluno(a) mais novo(a): %s", alunoMaisNovo);

        Intent it = new Intent(MainActivity.this, Activity2.class);
        it.putExtra("mediaTurma", mostrarMediaTurma);
        it.putExtra("mostrarAlunoMaisVelho",mostrarAlunoMaisVelho);
        it.putExtra("mostrarAlunoMaisNovo",mostrarAlunoMaisNovo);
        startActivity(it);
    }

    private void cadastroAluno() {
        String nome = editText_name.getText().toString();
        int idade = Integer.parseInt(editText_age.getText().toString());
        String nota1 = editText_nota1.getText().toString();
        String nota2 = editText_nota2.getText().toString();
        String nota3 = editText_nota3.getText().toString();

        double nota1Valor = Double.parseDouble(nota1);
        double nota2Valor = Double.parseDouble(nota2);
        double nota3Valor = Double.parseDouble(nota3);


        Aluno aluno = new Aluno(nome, idade, nota1Valor, nota2Valor, nota3Valor);
        alunoList.add(aluno);

        /*
        test
        System.out.println(alunoList.get(alunoList.size() - 1).getNome());
        System.out.println(alunoList.get(alunoList.size() - 1).verificaSituacao());
        System.out.println(alunoList.get(0).verificaSituacao());
        */
    }
    
    private double mediaTurma(){
        double mediaTurma = 0;
        for (Aluno aluno : alunoList) {
            mediaTurma += aluno.calculaMedia();
        }
        mediaTurma = mediaTurma/alunoList.size();
        return mediaTurma;
        //test
        //System.out.println(mediaTurma);
    }

    private String verificaAlunoMaisVelho(){
        int idade = -1;
        String alunoMaisVelho = null;

        for (Aluno aluno : alunoList) {
            if (idade < aluno.getIdade()){
                idade = aluno.getIdade();
                alunoMaisVelho = aluno.getNome();
            }
        }
        return alunoMaisVelho;
    }

    private String verificaAlunoMaisNovo(){
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
}
