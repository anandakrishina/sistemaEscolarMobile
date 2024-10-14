package com.krishina.suapkrishina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private TextView textView_relatorioGeral;
    private TextView textView_mostrarMediaTurma;
    private TextView textView_mostrarAlunoMaisVelho;
    private TextView textView_mostrarAlunoMaisNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);


        textView_relatorioGeral = findViewById(R.id.textView_relatorioGeral);
        textView_mostrarMediaTurma = findViewById(R.id.textView_mediaTurma);
        textView_mostrarAlunoMaisVelho = findViewById(R.id.textView_alunoMaisVelho);
        textView_mostrarAlunoMaisNovo = findViewById(R.id.textView_alunoMaisNovo);

        Intent it = getIntent();
        String intentRelatorioGeral = it.getStringExtra("relatorioGeral");
        String intentMediaTurma = it.getStringExtra("mediaTurma");
        String intentAlunoMaisVelho = it.getStringExtra("mostrarAlunoMaisVelho");
        String intentAlunoMaisNovo = it.getStringExtra("mostrarAlunoMaisNovo");


        textView_relatorioGeral.setText(intentRelatorioGeral);
        textView_mostrarMediaTurma.setText(intentMediaTurma);
        textView_mostrarAlunoMaisVelho.setText(intentAlunoMaisVelho);
        textView_mostrarAlunoMaisNovo.setText(intentAlunoMaisNovo);

    }
}