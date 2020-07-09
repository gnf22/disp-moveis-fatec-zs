package com.example.findStudents.views.aluno;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.MainMenu;

public class AlterarAlunos extends  Activity {
    EditText nome;
    EditText sexo;
    EditText idade;
    EditText cpf;
    Button alterar;
    Button deletar;
    Cursor cursor;
    String codigo;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.atualizar_alunos);
        tipo = this.getIntent().getStringExtra("tipo");

        codigo = this.getIntent().getStringExtra("codigo");

        nome = (EditText) findViewById(R.id.editText4);
        sexo = (EditText) findViewById(R.id.editText5);
        idade = (EditText) findViewById(R.id.editText6);
        cpf = (EditText) findViewById(R.id.editText7);
        alterar = (Button) findViewById(R.id.button2);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Nome'!", Toast.LENGTH_SHORT).show();
                } else if(sexo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Sexo'!", Toast.LENGTH_SHORT).show();
                } else if(idade.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Idade'!", Toast.LENGTH_SHORT).show();
                } else {
                    MainMenu.aluCont.alterarAluno(Integer.parseInt(codigo), nome.getText().toString(), sexo.getText().toString(), idade.getText().toString(), cpf.getText().toString());
                    Intent intent = new Intent(AlterarAlunos.this, ConsultaAlunos.class);
                    intent.putExtra("tipo", tipo);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cursor = MainMenu.aluCont.carregarAlunoPorID(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow("_nome")));
        sexo.setText(cursor.getString(cursor.getColumnIndexOrThrow("_sexo")));
        idade.setText(cursor.getString(cursor.getColumnIndexOrThrow("_idade")));
        cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow("_cpf")));

        deletar = (Button) findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.aluCont.deletarAluno(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarAlunos.this, ConsultaAlunos.class);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }
        });
    }
}
