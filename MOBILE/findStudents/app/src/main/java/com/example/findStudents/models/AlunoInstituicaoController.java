package com.example.findStudents.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.findStudents.utils.CriaBanco;

public class AlunoInstituicaoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public AlunoInstituicaoController(Context context) {
        banco = new CriaBanco(context);
        db = banco.getWritableDatabase();
        //banco.onUpgrade(db, 1, 2);
        //banco.onCreate(db);
    }

    public String inserirAlunoInstituicao(int idAluno, int idInstituicao, String observacao) {
        ContentValues valores;
        long resultado = 1;

        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("_idAluno", idAluno);
        valores.put("_idInstituicao", idInstituicao);
        valores.put("_observacao", observacao);

        db.beginTransaction();
        try {
            resultado = db.insert("aluno_instituicao", null, valores);
            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }

        if (resultado == -1) return  "Erro ao inserir registro";
        else return "Registro inserido com sucesso";
    }

    public Cursor carregarAlunoInstituicao() {
        Cursor cursor;
        String[] campos = {"_id", "_idAluno", "_idInstituicao", "_observacao"};
        db = banco.getReadableDatabase();
        cursor = db.query("aluno_instituicao", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarAlunoInstituicaoPorID(int id){
        Cursor cursor;
        String[] campos =  {"_id", "_idAluno", "_idInstituicao", "_observacao"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("aluno_instituicao" ,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarAlunoInstituicaoPorObservacao(String observacao){
        Cursor cursor;
        String[] campos =  {"_id", "_idAluno", "_idInstituicao", "_observacao"};
        String where = "_observacao LIKE ?";
        String[] whereArgs = new String[] { "%" + observacao + "%"};
        db = banco.getReadableDatabase();
        cursor = db.query("aluno_instituicao" ,campos, where, whereArgs, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarAlunoInstituicao(int id, int idAluno, int idInstituicao, String observacao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id=" + id;

        valores = new ContentValues();
        valores.put("_idAluno", idAluno);
        valores.put("_idInstituicao", idInstituicao);
        valores.put("_observacao", observacao);

        db.update("aluno_instituicao",valores,where,null);
        db.close();
    }

    public void deletarAlunoInstituicao(int id){
        String where = "_id=" + id;

        db = banco.getReadableDatabase();
        db.delete("aluno_instituicao",where,null);

        db.close();
    }



}
