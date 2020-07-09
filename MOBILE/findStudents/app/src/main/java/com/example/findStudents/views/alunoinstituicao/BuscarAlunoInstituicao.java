package com.example.findStudents.views.alunoinstituicao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.findStudents.R;

public class BuscarAlunoInstituicao extends Activity{
    String tipo;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_aluins);
        tipo = this.getIntent().getStringExtra("tipo");


        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText observacao = (EditText)findViewById(R.id.editText);
                String obervacaoString = observacao.getText().toString();

                Intent intent = new Intent(BuscarAlunoInstituicao.this, ConsultaAlunoInstituicaoParametro.class);
                intent.putExtra("observacao", obervacaoString);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
            }
        });
    }
}
