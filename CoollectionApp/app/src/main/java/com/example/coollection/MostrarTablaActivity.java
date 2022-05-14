package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.*;
import models.*;

public class MostrarTablaActivity extends AppCompatActivity {

    ListView listadatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tabla);

        listadatos = (ListView) findViewById(R.id.listadatos);

        Intent datos = getIntent();
        String tipotabla = datos.getStringExtra("tipotabla");

        switch (tipotabla){
            case "Usuarios":
                tablaUsuarios();
                break;
            case "Comentarios":
                tablaComentarios();
                break;
            case "Perfiles":
                tablaPerfiles();
                break;
            case "Imagenes":
                tablaImagenes();
                break;
            case "Publicaciones":
                tablaPublicaciones();
                break;
        }
    }

    public void tablaUsuarios(){
        ArrayList<Usuario> listausuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("tipolista");
        adapterUsuario adapter = new adapterUsuario(this, listausuarios);
        listadatos.setAdapter(adapter);
    }

    public void tablaImagenes(){
        ArrayList<Imagen> listaimagenes = (ArrayList<Imagen>) getIntent().getSerializableExtra("tipolista");
        adapterImagen adapter = new adapterImagen(this, listaimagenes);
        listadatos.setAdapter(adapter);
    }

    public void tablaPerfiles(){
        ArrayList<Perfil> listaperfiles = (ArrayList<Perfil>) getIntent().getSerializableExtra("tipolista");
        adapterPerfil adapter = new adapterPerfil(this, listaperfiles);
        listadatos.setAdapter(adapter);
    }

    public void tablaComentarios(){
        ArrayList<Comentario> listacomentarios = (ArrayList<Comentario>) getIntent().getSerializableExtra("tipolista");
        adapterComentario adapter = new adapterComentario(this, listacomentarios);
        listadatos.setAdapter(adapter);
    }

    public void tablaPublicaciones(){
        ArrayList<Publicacion> listapublicaciones = (ArrayList<Publicacion>) getIntent().getSerializableExtra("tipolista");
        adapterPublicacion adapter = new adapterPublicacion(this, listapublicaciones);
        listadatos.setAdapter(adapter);
    }
}