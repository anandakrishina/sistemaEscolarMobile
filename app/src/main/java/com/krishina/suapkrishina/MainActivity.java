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
    private AlunoMetodos alunoMetodos = new AlunoMetodos();


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
        String mostrarMediaTurma = String.format("Média da turma: %.2f", alunoMetodos.mediaTurma());
        String mostrarAlunoMaisVelho = String.format("Aluno(a) mais velho(a): %s", alunoMetodos.verificaAlunoMaisVelho());
        String mostrarAlunoMaisNovo = String.format("Aluno(a) mais novo(a): %s", alunoMetodos.verificaAlunoMaisNovo());
        String mostrarRelatorioGeral = alunoMetodos.mostrarRelatorioGeral();

        Intent it = new Intent(MainActivity.this, Activity2.class);
        it.putExtra("relatorioGeral", mostrarRelatorioGeral);
        it.putExtra("mediaTurma", mostrarMediaTurma);
        it.putExtra("mostrarAlunoMaisVelho",mostrarAlunoMaisVelho);
        it.putExtra("mostrarAlunoMaisNovo",mostrarAlunoMaisNovo);
        startActivity(it);
    }

    private void cadastroAluno() {
        String nome = editText_name.getText().toString();
        int idade = Integer.parseInt(editText_age.getText().toString());
        double nota1Valor = Double.parseDouble(editText_nota1.getText().toString());
        double nota2Valor = Double.parseDouble(editText_nota2.getText().toString());
        double nota3Valor = Double.parseDouble(editText_nota3.getText().toString());

        Aluno aluno = new Aluno(nome, idade, nota1Valor, nota2Valor, nota3Valor);
        alunoList.add(aluno);
        alunoMetodos.setAlunoList(alunoList);
    }
}
