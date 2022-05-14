package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText txtLogUser, txtLogPass;
    Button btnLogin, btnIrRegister, btnMostrarAlcances;
    TextView mostrarAlcances;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phpController = new PHPController(this);

        txtLogUser = (EditText) findViewById(R.id.txtLogUser);
        txtLogPass = (EditText) findViewById(R.id.txtLogPass);
        mostrarAlcances = (TextView) findViewById(R.id.mostrarAlcances);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnIrRegister = (Button) findViewById(R.id.btnIrRegister);
        btnMostrarAlcances = (Button) findViewById(R.id.btnMostrarAlcances);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingresar();
            }
        });

        btnIrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        btnMostrarAlcances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alcances();
            }
        });
    }

    public void Alcances(){
        String alcances = "Buscamos recrear una forma donde los usuarios\n" +
                "puedan almacenar sus fotos de la galeria en una nube\n" +
                "para garantizar la proteccion y el respaldo de los mismos.";

        mostrarAlcances.setText(alcances);
    }

    public void Ingresar(){
        String username = txtLogUser.getText().toString().trim();
        String password = txtLogPass.getText().toString().trim();
        phpController.Login(username, password);
    }
}