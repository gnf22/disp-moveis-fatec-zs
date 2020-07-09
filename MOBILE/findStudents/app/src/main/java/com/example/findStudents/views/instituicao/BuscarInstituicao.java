package com.example.findStudents.views.instituicao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.findStudents.R;

public class BuscarInstituicao extends Activity{
    String tipo;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_instituicao);
        tipo = this.getIntent().getStringExtra("tipo");

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText)findViewById(R.id.editText);
                String nomeString = nome.getText().toString();

                Intent intent = new Intent(BuscarInstituicao.this, ConsultaInstituicaoParametro.class);
                intent.putExtra("nome", nomeString);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
            }
        });
    }
}
