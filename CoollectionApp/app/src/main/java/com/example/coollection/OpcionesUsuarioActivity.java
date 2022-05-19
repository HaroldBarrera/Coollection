package com.example.coollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import models.Usuario;

public class OpcionesUsuarioActivity extends AppCompatActivity {

    //Contenido del layout
    ImageButton btnIrVerPublicaciones, btnIrEditarPerfil;

    //Cabecera
    TextView nusu;
    Intent datosusuario;

    //Barra de progreso
    ProgressBar barraProgreso;
    private boolean cargando;

    //PHP
    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_usuario);

        //Contenido del layout
        btnIrEditarPerfil = (ImageButton) findViewById(R.id.btnIrEditarPerfil);
        btnIrVerPublicaciones = (ImageButton) findViewById(R.id.btnIrVerPublicaciones);
        barraProgreso = (ProgressBar) findViewById(R.id.progresBarUser);

        //PHP
        phpController = new PHPController(this);

        //Cabecera
        nusu = (TextView) findViewById(R.id.nusu);
        datosusuario = getIntent();
        String nombreCompletoUsuario = datosusuario.getStringExtra("usuario");
        String idusuario = datosusuario.getStringExtra("idusuario");
        nusu.setText(nombreCompletoUsuario);

        //ClickListeners
        btnIrVerPublicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               VerPublicaciones();
            }
        });

        btnIrEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarPerfil(idusuario);
            }
        });
    }

    //Botones
    public void VerPublicaciones(){
        if(cargando) {
            barraProgreso.setVisibility(View.GONE);
        }
        else {
            barraProgreso.setVisibility(View.VISIBLE);
        }
        cargando = !cargando;
    }

    public void EditarPerfil(String id){
        System.out.println("ID CARGADA: " + id);
        phpController.ReadUsuario(id);
        if(cargando) {
            barraProgreso.setVisibility(View.GONE);
        }
        else {
            barraProgreso.setVisibility(View.VISIBLE);
        }
        cargando = !cargando;
    }

    //Menu desbordante
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //Participantes
        if(id == R.id.participantes){
            participantes();
            return true;
        }

        if(id == R.id.info_app){
            acercaApp();
            return true;
        }

        if(id == R.id.salir){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void acercaApp(){
        new AlertDialog.Builder(this)
                .setTitle("Acerca de la aplicacion")
                .setMessage("Esta es una galeria de fotos online")
                .setPositiveButton("Salir",
                        new DialogInterface.OnClickListener() {
                            @TargetApi(11)
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                finish();
                            }
                        })
                .setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
                    @TargetApi(11)
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    public void participantes(){
        new AlertDialog.Builder(this)
                .setTitle("Participantes")
                .setMessage("Harold Samuel Barrera Niño\nCristian Camilo Forero\nWilliam David Florez")
                .setPositiveButton("Salir",
                        new DialogInterface.OnClickListener() {
                            @TargetApi(11)
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                finish();
                            }
                        })
                .setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
                    @TargetApi(11)
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }
}