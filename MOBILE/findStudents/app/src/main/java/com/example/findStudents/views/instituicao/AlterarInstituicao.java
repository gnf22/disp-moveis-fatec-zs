package com.example.findStudents.views.instituicao;

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

public class AlterarInstituicao extends Activity {
    EditText nome;
    EditText ano_fund;
    EditText endereco;
    Button alterar;
    Button deletar;
    Cursor cursor;
    String codigo;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atualizar_instituicao);
        tipo = this.getIntent().getStringExtra("tipo");

        codigo = this.getIntent().getStringExtra("codigo");
        nome = (EditText) findViewById(R.id.editText4);
        ano_fund= (EditText) findViewById(R.id.editText5);
        endereco = (EditText) findViewById(R.id.editText6);

        alterar = (Button) findViewById(R.id.button2);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                if(nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Nome'!", Toast.LENGTH_SHORT).show();
                } else if(ano_fund.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Ano de Fundação'!", Toast.LENGTH_SHORT).show();
                } else if(endereco.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Endereço'!", Toast.LENGTH_SHORT).show();
                } else {
                    MainMenu.insCont.alterarInstituicao(Integer.parseInt(codigo), nome.getText().toString(), ano_fund.getText().toString(), endereco.getText().toString());
                    Intent intent = new Intent(AlterarInstituicao.this, ConsultaInstituicao.class);
                    intent.putExtra("tipo", tipo);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cursor = MainMenu.insCont.carregarInstituicaoPorID(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow("_nome")));
        ano_fund.setText(cursor.getString(cursor.getColumnIndexOrThrow("_ano_fund")));
        endereco.setText(cursor.getString(cursor.getColumnIndexOrThrow("_endereco")));

        deletar = (Button) findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.insCont.deletarInstituicao(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarInstituicao.this, ConsultaInstituicao.class);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }
        });
    }
}
