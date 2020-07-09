package com.example.findStudents.views.aluno;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.MainMenu;

public class InsereAlunos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_alunos);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText)findViewById(R.id.editText);
                EditText sexo = (EditText)findViewById(R.id.editText2);
                EditText idade = (EditText)findViewById(R.id.editText3);
                EditText cpf = (EditText)findViewById(R.id.editText8);

                String nomeString = nome.getText().toString();
                String sexoString = sexo.getText().toString();
                String idadeString = idade.getText().toString();
                String cpfString = cpf.getText().toString();
                String resultado;

                if(nomeString.equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Nome'!", Toast.LENGTH_SHORT).show();
                } else if(sexoString.equals("")) {
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Sexo'!", Toast.LENGTH_SHORT).show();
                } else if(idadeString.equals("")) {
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Idade'!", Toast.LENGTH_SHORT).show();
                }
                else {
                    resultado = MainMenu.aluCont.inserirAluno(nomeString, sexoString, idadeString, cpfString);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
                    if(resultado.equals("Registro Inserido com sucesso")){
                        nome.setText("");
                        sexo.setText("");
                        idade.setText("");
                        cpf.setText("");
                    }
                }

            }
        });
    }
}
