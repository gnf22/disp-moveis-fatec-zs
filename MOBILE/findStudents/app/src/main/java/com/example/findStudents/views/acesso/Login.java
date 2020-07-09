package com.example.findStudents.views.acesso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findStudents.R;
import com.example.findStudents.models.UsuarioController;
import com.example.findStudents.views.usuario.CadastroUsuario;

public class Login extends AppCompatActivity {
    private EditText senhaText;
    private EditText loginText;

    public static UsuarioController usuCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(usuCont == null) usuCont = new UsuarioController(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginText = (EditText) findViewById(R.id.login);
        senhaText = (EditText) findViewById(R.id.senha);

        Button login = (Button) findViewById(R.id.btentrar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipo;
                String loginString = loginText.getText().toString();
                String senhaString = senhaText.getText().toString();

                String position = Login.usuCont.ValidarUsuario(loginString, senhaString);
                int positionInt = Integer.parseInt(position);
                if (positionInt > 0) {
                    Cursor cursor = Login.usuCont.carregarUsuarioPorID(Integer.parseInt(position));
                    tipo = cursor.getString(cursor.getColumnIndex("_tipo"));
                    Intent myIntent = new Intent(Login.this, MainMenu.class);
                    myIntent.putExtra("tipo", tipo);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    public void InsereUsuario(View view) {
        Intent myIntent = new Intent(this, CadastroUsuario.class);
        this.startActivity(myIntent);
    }
}
