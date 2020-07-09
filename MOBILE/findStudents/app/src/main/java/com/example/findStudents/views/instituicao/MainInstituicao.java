package com.example.findStudents.views.instituicao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.findStudents.R;

public class MainInstituicao extends Activity {
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipo = this.getIntent().getStringExtra("tipo");
        if(tipo.equals("ADM")){
            setContentView(R.layout.activity_instituicao);
        } else {
            setContentView(R.layout.activity_instituicao_visit);
        }
    }

    public void InserirInstituicao(View view) {
        Intent myIntent = new Intent(this, InsereInstituicao.class);
        this.startActivity(myIntent);
    }

    public void ConsultarInstituicao(View view) {
        Intent myIntent = new Intent(this, ConsultaInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void BuscarInstituicao(View view) {
        Intent myIntent = new Intent(this, BuscarInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }


}
