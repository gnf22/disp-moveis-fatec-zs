package com.example.findStudents.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CriaBanco extends SQLiteOpenHelper {

    public CriaBanco(Context context){
        super(context, "banco.db", null, 1);
    };

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("SQLITE", "CREATED!");
        db.execSQL("CREATE TABLE IF NOT EXISTS `alunos`(`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `_nome` text NOT NULL, `_sexo` text NOT NULL, `_idade` text NOT NULL, `_cpf` text NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `instituicao`(`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `_nome` text NOT NULL, `_ano_fund` text NOT NULL, `_endereco` text NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `aluno_instituicao`" +
                "(`_id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "`_idAluno` INTEGER NOT NULL, " +
                "`_idInstituicao` INTEGER NOT NULL, " +
                "`_observacao` text NOT NULL," +
                "FOREIGN KEY (`_idAluno`) REFERENCES `alunos`(`_id`) ON DELETE CASCADE," +
                "FOREIGN KEY (`_idInstituicao`) REFERENCES `instituicao`(`_id`) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE IF NOT EXISTS `usuario`(`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `_nome` TEXT NOT NULL, `_login` TEXT NOT NULL, `_senha` TEXT NOT NULL, `_tipo` TEXT NOT NULL)");
        db.execSQL("INSERT INTO `usuario` VALUES(1, 'ADM', 'adm', 'adm', 'ADM')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("SQLITE", "UPGRADED!");
        db.execSQL("DROP TABLE IF EXISTS `usuario`");
        db.execSQL("DROP TABLE IF EXISTS `aluno_instituicao`");
        db.execSQL("DROP TABLE IF EXISTS `instituicao`");
        db.execSQL("DROP TABLE IF EXISTS `alunos`");
        onCreate(db);
    }
}
