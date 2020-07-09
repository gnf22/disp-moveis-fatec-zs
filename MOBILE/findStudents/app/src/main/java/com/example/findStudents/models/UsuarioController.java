package com.example.findStudents.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.findStudents.utils.CriaBanco;

public class UsuarioController {

    private SQLiteDatabase db;
    private CriaBanco banco;


    public UsuarioController(Context context) {
        banco = new CriaBanco(context);
        db = banco.getWritableDatabase();
        //banco.onUpgrade(db, 1, 2);
        //banco.onCreate(db);
    }

    public String inserirUsuario(String nome, String login, String senha, String tipo) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        
        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_login", login);
        valores.put("_senha", senha);
        valores.put("_tipo", tipo);

        resultado = db.insert("usuario", null, valores);
        db.close();

        if (resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public String ValidarUsuario(String login, String senha){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_login", "_senha", "_tipo"};
        String where = "_login= ? AND _senha = ?";
        String[] whereArgs = new String[] {login, senha};
        db = banco.getReadableDatabase();
        cursor = db.query("usuario" ,campos,where, whereArgs, null, null, null, null);
        if(cursor.moveToFirst()) {
            return cursor.getString(0);
        }
            db.close();
            return "-1";
    }

    public Cursor carregarUsuarios() {
        Cursor cursor;
        String[] campos = {"_id", "_nome", "_login", "_senha", "_tipo"};
        db = banco.getReadableDatabase();
        cursor = db.query("usuario", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarUsuario(int id, String nome, String login, String senha, String tipo){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id=" + id;

        valores = new ContentValues();
        valores.put("_nome", nome);
        valores.put("_login", login);
        valores.put("_senha", senha);
        valores.put("_tipo", tipo);

        db.update("usuario",valores,where,null);
        db.close();
    }

    public Cursor carregarUsuarioPorID(int id){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_login", "_senha", "_tipo"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();

        cursor = db.query("usuario" ,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void deletarUusario(int id){
        String where = "_id=" + id;

        db = banco.getReadableDatabase();
        db.delete("usuario",where,null);

        db.close();
    }

    public Cursor carregarUsuariosPorNome(String nome){
        Cursor cursor;
        String[] campos =  {"_id", "_nome", "_login", "_senha", "_tipo"};
        String where = "_nome LIKE ?";
        String[] whereArgs = new String[] { "%" + nome + "%"};
        db = banco.getReadableDatabase();
        cursor = db.query("usuario" ,campos, where, whereArgs, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
