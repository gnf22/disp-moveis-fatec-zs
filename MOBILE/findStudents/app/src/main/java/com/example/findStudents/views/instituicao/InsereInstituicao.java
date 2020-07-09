package com.example.findStudents.views.instituicao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.MainMenu;

public class InsereInstituicao extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_instituicao);

        Button botao = (Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText)findViewById(R.id.editText);
                EditText ano_fund = (EditText)findViewById(R.id.editText2);
                EditText endereco = (EditText)findViewById(R.id.editText3);

                String nomeString = nome.getText().toString();
                String ano_fundString = ano_fund.getText().toString();
                String enderecoString = endereco.getText().toString();
                String resultado;

                if(nomeString.equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Nome'!", Toast.LENGTH_SHORT).show();
                } else if (ano_fundString.equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Ano de Fundação'!", Toast.LENGTH_SHORT).show();
                } else if(enderecoString.equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Endereço'!", Toast.LENGTH_SHORT).show();
                } else {
                    resultado = MainMenu.insCont.inserirInstituicao(nomeString, ano_fundString, enderecoString);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
                    if(resultado.equals("Registro Inserido com sucesso")){
                        nome.setText("");
                        ano_fund.setText("");
                        endereco.setText("");
                    }
                }

            }
        });
    }
}
