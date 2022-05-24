package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.*;
import models.*;

public class MostrarTablaActivity extends AppCompatActivity {

    ListView listadatos;
    Button btnCrearDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tabla);

        btnCrearDato = (Button) findViewById(R.id.btnCrearDato);
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
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                System.out.println("USUARIO = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "21");
                intent.putExtra("id", listausuarios.get(i).getId());
                intent.putExtra("nombre", listausuarios.get(i).getNombre());
                intent.putExtra("apellido", listausuarios.get(i).getApellido());
                intent.putExtra("correo", listausuarios.get(i).getCorreo());
                intent.putExtra("username", listausuarios.get(i).getUsername());
                intent.putExtra("password", listausuarios.get(i).getPassword());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                i.putExtra("accion", "11");
                startActivity(i);
            }
        });
    }

    public void tablaImagenes(){
        ArrayList<Imagen> listaimagenes = (ArrayList<Imagen>) getIntent().getSerializableExtra("tipolista");
        adapterImagen adapter = new adapterImagen(this, listaimagenes);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                System.out.println("IMAGENES = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "22");
                intent.putExtra("id", listaimagenes.get(i).getIdimagen());
                intent.putExtra("imagen", listaimagenes.get(i).getImagen());
                intent.putExtra("descripcion", listaimagenes.get(i).getDescripcion());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                i.putExtra("accion", "12");
                startActivity(i);
            }
        });
    }

    public void tablaPerfiles(){
        ArrayList<Perfil> listaperfiles = (ArrayList<Perfil>) getIntent().getSerializableExtra("tipolista");
        adapterPerfil adapter = new adapterPerfil(this, listaperfiles);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                System.out.println("PERFILES = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "23");
                intent.putExtra("id", listaperfiles.get(i).getIdperfil());
                intent.putExtra("tipo", listaperfiles.get(i).getTipo());
                intent.putExtra("codigo", listaperfiles.get(i).getCodigo());
                intent.putExtra("idusuario", listaperfiles.get(i).getIdusuario());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                i.putExtra("accion", "13");
                startActivity(i);
            }
        });
    }

    public void tablaComentarios(){
        ArrayList<Comentario> listacomentarios = (ArrayList<Comentario>) getIntent().getSerializableExtra("tipolista");
        adapterComentario adapter = new adapterComentario(this, listacomentarios);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                System.out.println("COMENTARIOS = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "24");
                intent.putExtra("id", listacomentarios.get(i).getIdcomentario());
                intent.putExtra("texto", listacomentarios.get(i).getTexto());
                intent.putExtra("idpublicacion", listacomentarios.get(i).getIdpublicacion());
                intent.putExtra("idusuario", listacomentarios.get(i).getIdusuario());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                i.putExtra("accion", "14");
                startActivity(i);
            }
        });
    }

    public void tablaPublicaciones(){
        ArrayList<Publicacion> listapublicaciones = (ArrayList<Publicacion>) getIntent().getSerializableExtra("tipolista");
        adapterPublicacion adapter = new adapterPublicacion(this, listapublicaciones);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                System.out.println("PUBLICACIONES = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "25");
                intent.putExtra("id", listapublicaciones.get(i).getIdpublicacion());
                intent.putExtra("idusuario", listapublicaciones.get(i).getIdusuario());
                intent.putExtra("idimagen", listapublicaciones.get(i).getIdimagen());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                i.putExtra("accion", "15");
                startActivity(i);
            }
        });
    }
}