package com.example.findStudents.views.alunoinstituicao;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.views.acesso.MainMenu;

public class ConsultaAlunoInstituicaoParametro extends Activity {
    private ListView lista;
    String observacao;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_aluins);
        tipo = this.getIntent().getStringExtra("tipo");
        observacao = this.getIntent().getStringExtra("observacao");

        final Cursor cursor = MainMenu.aluInsCont.carregarAlunoInstituicaoPorObservacao(observacao);

        String[] nomeCampos = new String[]{"_id", "_idAluno", "_idInstituicao", "_observacao"};
        int [] idViews = new int[] {R.id.idAluIns, R.id.idAlu, R.id.idIns, R.id.observacao};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.aluins_layout, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo, codigoAlu, codigoIns;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                codigoAlu = Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow("_idAluno")));
                codigoIns = Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow("_idInstituicao")));

                Intent intent = new Intent(ConsultaAlunoInstituicaoParametro.this, AlterarAlunoInstituicao.class);
                intent.putExtra("codigo", codigo);
                intent.putExtra("codigoAluno", codigoAlu);
                intent.putExtra("codigoIns", codigoIns);
                intent.putExtra("tipo", tipo);

                if(tipo.equals("ADM")){
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Somente ADM pode alterar ou excluir registro.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
