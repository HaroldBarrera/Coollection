package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpcionesAdminActivity extends AppCompatActivity {

    TextView nusu;
    Intent datosusuario;

    Button btnTablaUsuarios, btnTablaComentarios, btnTablaPerfiles, btnTablaImagenes, btnTablaPublicaciones;

    PHPController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_admin);

        controller = new PHPController(this);

        nusu = (TextView) findViewById(R.id.nusu);
        datosusuario = getIntent();

        String nombreCompletoUsuario = datosusuario.getStringExtra("usuario");
        nusu.setText(nombreCompletoUsuario);

        btnTablaUsuarios = (Button) findViewById(R.id.btnTablaUsuarios);
        btnTablaComentarios = (Button) findViewById(R.id.btnTablaComentarios);
        btnTablaPerfiles = (Button) findViewById(R.id.btnTablaPerfiles);
        btnTablaImagenes = (Button) findViewById(R.id.btnTablaImagenes);
        btnTablaPublicaciones = (Button) findViewById(R.id.btnTablaPublicaciones);

        btnTablaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.ReadAllUsuarios();
            }
        });

        btnTablaComentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.ReadAllComentarios();
            }
        });

        btnTablaPerfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.ReadAllPerfiles();
            }
        });

        btnTablaImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.ReadAllImagenes();
            }
        });

        btnTablaPublicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.ReadAllPublicaciones();
            }
        });
    }
}