package com.example.findStudents.views.alunoinstituicao;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.MainMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class InsereAlunoInstituicao extends Activity {
    public Spinner spinnerAluno, spinnerInstituicao;
    ArrayAdapter<String> adapter, adapterIns;
    ArrayList<String> alunos, instituicoes;
    HashMap<String, Integer> dados, dadosIns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_aluins);

        Button botao = findViewById(R.id.button);
        spinnerAluno = findViewById(R.id.alunoSpinner);
        spinnerInstituicao = findViewById(R.id.editText2);

        dados = new HashMap<>();
        dadosIns = new HashMap<>();
        alunos = new ArrayList<>();
        instituicoes = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAluno.setAdapter(adapter);

        adapterIns = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, instituicoes);
        adapterIns.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInstituicao.setAdapter(adapterIns);

        Cursor cursor = MainMenu.aluCont.carregarAlunos();
        Log.i("SQLITE", String.valueOf(cursor.getColumnCount()));
        if(cursor.isFirst()) {
            int id = cursor.getInt(0);
            String aluno = id + " - " + cursor.getString(1);
            dados.put(aluno, id);
            adapter.add(aluno);
        }
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String aluno = id + " - " + cursor.getString(1);
            dados.put(aluno, id);
            adapter.add(aluno);
        }
        adapter.notifyDataSetChanged();

        Cursor cursorIns = MainMenu.insCont.carregarInstituicoes();
        Log.i("SQLITE", String.valueOf(cursorIns.getColumnCount()));
        if(cursorIns.isFirst()) {
            int id = cursorIns.getInt(0);
            String instituicao = id + " - " + cursorIns.getString(1);
            dadosIns.put(instituicao, id);
            adapterIns.add(instituicao);
        }
        while (cursorIns.moveToNext()) {
            int id = cursorIns.getInt(0);
            String instituicao = id + " - " + cursorIns.getString(1);
            dadosIns.put(instituicao, id);
            adapterIns.add(instituicao);
        }
        adapterIns.notifyDataSetChanged();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerAluno.getSelectedItem() == null) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar um aluno!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String aluno = spinnerAluno.getSelectedItem().toString();
                if(aluno.length() == 0 || !dados.containsKey(aluno)) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar um aluno!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(spinnerInstituicao.getSelectedItem() == null) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar uma instituição!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String instituicao = spinnerInstituicao.getSelectedItem().toString();
                if(instituicao.length() == 0 || !dadosIns.containsKey(instituicao)) {
                    Toast.makeText(getApplicationContext(), "Você precisa selecionar uma instituição!", Toast.LENGTH_SHORT).show();
                    return;
                }

                EditText observacao = (EditText)findViewById(R.id.editText3);
                String observacaoString = observacao.getText().toString();
                String resultado;

                if(observacaoString.equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Observação'!", Toast.LENGTH_SHORT).show();
                } else {
                    resultado = MainMenu.aluInsCont.inserirAlunoInstituicao(dados.get(aluno), dadosIns.get(instituicao), observacaoString);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();

                    if(resultado.equals("Registro inserido com sucesso")){
                        spinnerAluno.setSelection(0);
                        spinnerInstituicao.setSelection(0);
                        observacao.setText("");
                    }
                }


            }
        });
    }
}
