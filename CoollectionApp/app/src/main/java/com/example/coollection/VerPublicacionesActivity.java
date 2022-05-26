package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.adapterImagen;
import models.Imagen;

public class VerPublicacionesActivity extends AppCompatActivity {

    Button goback;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_publicaciones);

        goback = (Button) findViewById(R.id.btn_goback);
        lista = (ListView) findViewById(R.id.lista);

        ArrayList<Imagen> listaimagenes = (ArrayList<Imagen>) getIntent().getSerializableExtra("tipolista");
        adapterImagen adapter = new adapterImagen(this, listaimagenes);
        lista.setAdapter(adapter);
    }
}