package com.example.findStudents.views.usuario;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.Login;

public class AlterarUsuario extends  Activity {
    EditText nome;
    EditText login;
    EditText senha;
    EditText tipo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    String codigo;
    String tipoADM;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.atualizar_usuarios);
        tipoADM = this.getIntent().getStringExtra("tipo");

        codigo = this.getIntent().getStringExtra("codigo");

        nome = (EditText) findViewById(R.id.editText4);
        login = (EditText) findViewById(R.id.editText5);
        senha = (EditText) findViewById(R.id.editText6);
        tipo = (EditText) findViewById(R.id.editText7);

        alterar = (Button) findViewById(R.id.button2);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Nome'!", Toast.LENGTH_SHORT).show();
                } else if(login.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Login'!", Toast.LENGTH_SHORT).show();
                } else if(senha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Senha'!", Toast.LENGTH_SHORT).show();
                } else if(tipo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Tipo'!", Toast.LENGTH_SHORT).show();
                } else if(senha.getText().toString().length() < 5) {
                    Toast.makeText(getApplicationContext(), "Sua senha deve conter no mínimo 5 caracteres.", Toast.LENGTH_SHORT).show();
                } else {
                    Login.usuCont.alterarUsuario(Integer.parseInt(codigo), nome.getText().toString(), login.getText().toString(), senha.getText().toString(), tipo.getText().toString());
                    Intent intent = new Intent(AlterarUsuario.this, ConsultaUsuario.class);
                    intent.putExtra("tipo", tipoADM);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cursor = Login.usuCont.carregarUsuarioPorID(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow("_nome")));
        login.setText(cursor.getString(cursor.getColumnIndexOrThrow("_login")));
        senha.setText(cursor.getString(cursor.getColumnIndexOrThrow("_senha")));
        tipo.setText(cursor.getString(cursor.getColumnIndexOrThrow("_tipo")));

        deletar = (Button) findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.usuCont.deletarUusario(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarUsuario.this, ConsultaUsuario.class);
                intent.putExtra("tipo", tipoADM);
                startActivity(intent);
                finish();
            }
        });
    }
}
