package com.example.findStudents.views.alunoinstituicao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.findStudents.R;

public class MainAlunoInstituicao extends Activity {
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipo = this.getIntent().getStringExtra("tipo");
        if(tipo.equals("ADM")){
            setContentView(R.layout.activity_aluins);
        } else {
            setContentView(R.layout.activity_aluins_visit);
        }
    }

    public void InserirAlunoInstituicao(View view) {
        Intent myIntent = new Intent(this, InsereAlunoInstituicao.class);
        this.startActivity(myIntent);
    }

    public void ConsultarAlunoInstituicao(View view) {
        Intent myIntent = new Intent(this, ConsultaAlunoInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void BuscarAlunoInstituicao(View view) {
        Intent myIntent = new Intent(this, BuscarAlunoInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }


}
