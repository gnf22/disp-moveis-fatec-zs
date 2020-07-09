package com.example.findStudents.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.findStudents.utils.CriaBanco;

public class InstituicaoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public InstituicaoController(Context context) {
        banco = new CriaBanco(context);
        db = banco.getWritableDatabase();
        //banco.onUpgrade(db, 1, 2);
        //banco.onCreate(db);
    }

    public String inserirInstituicao(String nome, String ano_fund, String endereco) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_ano_fund", ano_fund);
        valores.put("_endereco", endereco);

        resultado = db.insert("instituicao", null, valores);
        db.close();

        if (resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public Cursor carregarInstituicoes() {
        Cursor cursor;
        String[] campos = {"_id", "_nome", "_ano_fund", "_endereco"};
        db = banco.getReadableDatabase();
        cursor = db.query("instituicao", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarInstituicaoPorNome(String nome){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_ano_fund", "_endereco"};
        String where = "_nome LIKE ?";
        String[] whereArgs = new String[] { "%" + nome + "%"};
        db = banco.getReadableDatabase();
        cursor = db.query("instituicao" ,campos, where, whereArgs, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarInstituicaoPorID(int id){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_ano_fund", "_endereco"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("instituicao" ,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarInstituicao(int id, String nome, String ano_fund, String endereco){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id=" + id;

        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_ano_fund", ano_fund);
        valores.put("_endereco", endereco);

        db.update("instituicao",valores,where,null);
        db.close();
    }

    public void deletarInstituicao(int id){
        String where = "_id=" + id;

        db = banco.getReadableDatabase();
        db.delete("instituicao",where,null);

        db.close();
    }
}
