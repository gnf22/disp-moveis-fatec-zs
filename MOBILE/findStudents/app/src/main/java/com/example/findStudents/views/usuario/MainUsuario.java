package com.example.findStudents.views.usuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.findStudents.R;

public class MainUsuario extends Activity {
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipo = this.getIntent().getStringExtra("tipo");
        if(tipo.equals("ADM")){
            setContentView(R.layout.activity_usuario);
        } else {
            setContentView(R.layout.activity_usuario_visit);
        }
    }

    public void InsereUsuario(View view) {
        Intent myIntent = new Intent(this, InsereUsuario.class);
        this.startActivity(myIntent);
    }

    public void ConsultarUsuario(View view) {
        Intent myIntent = new Intent(this, ConsultaUsuario.class);
        myIntent.putExtra("tipo", tipo);

        this.startActivity(myIntent);
    }

    public void BuscarUsuario(View view) {
        Intent myIntent = new Intent(this, BuscarUsuario.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }


}
