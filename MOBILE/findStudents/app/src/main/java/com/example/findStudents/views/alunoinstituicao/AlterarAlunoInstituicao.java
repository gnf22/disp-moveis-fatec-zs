package com.example.findStudents.views.alunoinstituicao;

import android.app.Activity;
import android.content.Intent;
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

public class AlterarAlunoInstituicao extends Activity {
    EditText observacao;
    public Spinner spinnerAluno, spinnerInstituicao;
    ArrayAdapter<String> adapter, adapterIns;
    ArrayList<String> alunos, instituicoes;
    HashMap<String, Integer> dados, dadosIns;
    Button alterar;
    Button deletar;
    String codigo, codigoAlu, codigoIns;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atualizar_aluins);

        tipo = this.getIntent().getStringExtra("tipo");
        codigo = this.getIntent().getStringExtra("codigo");
        codigoAlu = this.getIntent().getStringExtra("codigoAluno");
        codigoIns = this.getIntent().getStringExtra("codigoIns");

        observacao = (EditText) findViewById(R.id.editText3);

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
            int idAux = id;
            int pos = 0;
            String aluno = id + " - " + cursor.getString(1);

            while (idAux != Integer.parseInt(codigoAlu)){
                if (idAux < Integer.parseInt(codigoAlu)) {
                    idAux++;
                    pos++;
                    spinnerAluno.setSelection(pos);
                }
            }
            dados.put(aluno, id);
            adapter.add(aluno);
        }
        adapter.notifyDataSetChanged();
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
            int idAux = id;
            String instituicao = id + " - " + cursorIns.getString(1);

            int pos = 0;

            while (idAux != Integer.parseInt(codigoIns)){
                if(idAux < Integer.parseInt(codigoIns)) {
                    idAux++;
                    pos++;
                    spinnerInstituicao.setSelection(pos);
                }
            }
            dadosIns.put(instituicao, id);
            adapterIns.add(instituicao);
        }
        adapterIns.notifyDataSetChanged();
        while (cursorIns.moveToNext()) {
            int id = cursorIns.getInt(0);
            String instituicao = id + " - " + cursorIns.getString(1);
            dadosIns.put(instituicao, id);
            adapterIns.add(instituicao);


        }
        adapterIns.notifyDataSetChanged();

        alterar = (Button) findViewById(R.id.button);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aluno = spinnerAluno.getSelectedItem().toString();
                String instituicao = spinnerInstituicao.getSelectedItem().toString();

                if(observacao.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Você precisa preencher o campo 'Observação'!", Toast.LENGTH_SHORT).show();
                } else {
                    MainMenu.aluInsCont.alterarAlunoInstituicao(Integer.parseInt(codigo), dados.get(aluno), dadosIns.get(instituicao), observacao.getText().toString());
                    Intent intent = new Intent(AlterarAlunoInstituicao.this, ConsultaAlunoInstituicao.class);
                    intent.putExtra("tipo", tipo);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cursor = MainMenu.aluInsCont.carregarAlunoInstituicaoPorID(Integer.parseInt(codigo));
        observacao.setText(cursor.getString(cursor.getColumnIndexOrThrow("_observacao")));


        deletar = (Button) findViewById(R.id.button14);

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.aluInsCont.deletarAlunoInstituicao(Integer.parseInt(codigo));
                Intent intent = new Intent (AlterarAlunoInstituicao.this, ConsultaAlunoInstituicao.class);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }
        });
    }
}
