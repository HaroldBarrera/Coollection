package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText txtRegNombre, txtRegApellido, txtRegCorreo, txtRegUser, txtRegPass;
    Button btnRegister, btnIrLogin;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phpController = new PHPController(this);

        txtRegNombre = (EditText) findViewById(R.id.txtRegNombre);
        txtRegApellido = (EditText) findViewById(R.id.txtRegApellido);
        txtRegCorreo = (EditText) findViewById(R.id.txtRegCorreo);
        txtRegUser = (EditText) findViewById(R.id.txtRegUser);
        txtRegPass = (EditText) findViewById(R.id.txtRegPass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnIrLogin = (Button) findViewById(R.id.btnIrLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre, apellido, correo, username, password;
                nombre = txtRegNombre.getText().toString().trim();
                apellido = txtRegApellido.getText().toString().trim();
                correo = txtRegCorreo.getText().toString().trim();
                username = txtRegUser.getText().toString().trim();
                password = txtRegPass.getText().toString().trim();
                phpController.Register(nombre, apellido, correo, username, password);
            }
        });

        btnIrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}