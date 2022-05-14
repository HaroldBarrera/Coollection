package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import models.Usuario;

public class OpcionesUsuarioActivity extends AppCompatActivity {

    //Contenido del layout

    //Cabecera
    TextView nusu;
    Intent datosusuario;

    //PHP
    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_usuario);

        //Contenido del layout

        //PHP
        phpController = new PHPController(this);

        //Cabecera
        nusu = (TextView) findViewById(R.id.nusu);
        datosusuario = getIntent();
        String nombreCompletoUsuario = datosusuario.getStringExtra("usuario");
        nusu.setText(nombreCompletoUsuario);

    }

}