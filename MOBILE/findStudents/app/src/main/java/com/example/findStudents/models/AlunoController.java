package com.example.findStudents.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.findStudents.utils.CriaBanco;


public class AlunoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public AlunoController(Context context) {
        banco = new CriaBanco(context);
        db = banco.getWritableDatabase();
        //banco.onUpgrade(db, 1, 2);
        //banco.onCreate(db);
    }

    public String inserirAluno(String nome, String sexo, String idade, String cpf) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_sexo", sexo);
        valores.put("_idade", idade);
        valores.put("_cpf", cpf);

        resultado = db.insert("alunos", null, valores);
        db.close();

        if (resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public Cursor carregarAlunos() {
        Cursor cursor;
        String[] campos = {"_id", "_nome", "_sexo", "_idade"};
        db = banco.getReadableDatabase();
        cursor = db.query("alunos", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarAlunoPorID(int id){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_sexo", "_idade", "_cpf"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("alunos" ,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarAlunosPorNome(String nome){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_sexo", "_idade", "_cpf"};
        String where = "_nome LIKE ?";
        String[] whereArgs = new String[] { "%" + nome + "%"};
        db = banco.getReadableDatabase();
        cursor = db.query("alunos" ,campos, where, whereArgs, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarAluno(int id, String nome, String sexo, String idade, String cpf){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id=" + id;

        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_sexo", sexo);
        valores.put("_idade", idade);
        valores.put("_cpf", cpf);

        db.update("alunos",valores,where,null);
        db.close();
    }

    public void deletarAluno(int id){
        String where = "_id=" + id;

        db = banco.getReadableDatabase();
        db.delete("alunos",where,null);

        db.close();
    }
}
