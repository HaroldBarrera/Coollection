package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class EditarPerfilActivity extends AppCompatActivity {

    EditText txtEditNombre, txtEditApellido, txtEditCorreo, txtEditUsername, txtEditPassword;
    Button btnEditPerfil;

    PHPController controller;

    ProgressBar barraProgreso;
    private boolean cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        controller = new PHPController(this);

        Intent datosusuario = getIntent();

        String uid = datosusuario.getStringExtra("usuid");
        String unom = datosusuario.getStringExtra("usunombre");
        String uape = datosusuario.getStringExtra("usuapellido");
        String ucor = datosusuario.getStringExtra("usucorreo");
        String user = datosusuario.getStringExtra("usuUsername");
        String upas = datosusuario.getStringExtra("usuPassword");

        txtEditNombre = (EditText) findViewById(R.id.txtEditNombre);
        txtEditApellido = (EditText) findViewById(R.id.txtEditApellido);
        txtEditCorreo = (EditText) findViewById(R.id.txtEditCorreo);
        txtEditUsername = (EditText) findViewById(R.id.txtEditUsername);
        txtEditPassword = (EditText) findViewById(R.id.txtEditPassword);
        btnEditPerfil = (Button) findViewById(R.id.btnEditPerfil);
        barraProgreso = (ProgressBar) findViewById(R.id.progresBarEditUser);

        txtEditNombre.setText(unom);
        txtEditApellido.setText(uape);
        txtEditCorreo.setText(ucor);
        txtEditUsername.setText(user);
        txtEditPassword.setText(upas);

        btnEditPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newnombre = txtEditNombre.getText().toString().trim();
                String newapellido = txtEditApellido.getText().toString().trim();
                String newcorreo = txtEditCorreo.getText().toString().trim();
                String newusername = txtEditUsername.getText().toString().trim();
                String newpassword = txtEditPassword.getText().toString().trim();

                controller.EditUser(uid, newnombre, newapellido, newcorreo, newusername, newpassword);
                if(cargando) {
                    barraProgreso.setVisibility(View.GONE);
                }
                else {
                    barraProgreso.setVisibility(View.VISIBLE);
                }
                cargando = !cargando;
            }
        });
    }
}