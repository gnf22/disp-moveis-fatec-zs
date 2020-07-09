package com.example.findStudents.views.aluno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.findStudents.R;

public class MainAluno extends Activity {
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipo = this.getIntent().getStringExtra("tipo");
        if(tipo.equals("ADM")){
            setContentView(R.layout.activity_aluno);
        } else {
            setContentView(R.layout.activity_aluno_visit);
        }
    }

    public void InserirAlunos(View view) {
        Intent myIntent = new Intent(this, InsereAlunos.class);
        this.startActivity(myIntent);
    }

    public void ConsultarAlunos(View view) {
        Intent myIntent = new Intent(this, ConsultaAlunos.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void BuscarAluno(View view) {
        Intent myIntent = new Intent(this, BuscarAlunos.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }
}
