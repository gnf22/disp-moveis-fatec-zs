package com.example.findStudents.views.instituicao;

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

public class ConsultaInstituicaoParametro extends Activity {
    private ListView lista;
    String nome;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_instituicao);
        tipo = this.getIntent().getStringExtra("tipo");
        nome = this.getIntent().getStringExtra("nome");

        final Cursor cursor = MainMenu.insCont.carregarInstituicaoPorNome(nome);
        String[] nomeCampos = new String[]{"_id", "_nome", "_ano_fund", "_endereco"};
        int[] idViews = new int[]{ R.id.idInstituicao, R.id.nomeInstituicao, R.id.ano_fundInstituicao, R.id.enderecoInstituicao};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.instituicao_layout, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));

                Intent intent = new Intent(ConsultaInstituicaoParametro.this, AlterarInstituicao.class);
                intent.putExtra("codigo", codigo);
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
