package com.example.findStudents.views.acesso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.findStudents.R;
import com.example.findStudents.models.AlunoController;
import com.example.findStudents.models.AlunoInstituicaoController;
import com.example.findStudents.models.InstituicaoController;
import com.example.findStudents.views.aluno.MainAluno;
import com.example.findStudents.views.alunoinstituicao.MainAlunoInstituicao;
import com.example.findStudents.views.instituicao.MainInstituicao;
import com.example.findStudents.views.usuario.MainUsuario;


public class MainMenu extends AppCompatActivity {

    public static AlunoController aluCont;
    public static InstituicaoController insCont;
    public static AlunoInstituicaoController aluInsCont;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(aluCont == null) aluCont = new AlunoController(this);
        if(insCont == null) insCont = new InstituicaoController(this);
        if(aluInsCont == null) aluInsCont = new AlunoInstituicaoController(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipo = this.getIntent().getStringExtra("tipo");

        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }


    public void MainAluno(View view) {
        Intent myIntent = new Intent(this, MainAluno.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void MainInstituicao(View view) {
        Intent myIntent = new Intent(this, MainInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void MainAlunoInstituicao(View view) {
        Intent myIntent = new Intent(this, MainAlunoInstituicao.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }

    public void MainUsuario(View view) {
        Intent myIntent = new Intent(this, MainUsuario.class);
        myIntent.putExtra("tipo", tipo);
        this.startActivity(myIntent);
    }
}
