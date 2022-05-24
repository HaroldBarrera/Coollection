package com.example.coollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class CrudActivity extends AppCompatActivity {

    EditText campoId, campo1, campo2, campo3, campo4, campo5;
    Button editarCampos, eliminarCampos, crearCampos;

    PHPController controller;

    Intent datosrecibidos;

    //Progress bar
    ProgressBar progressBar;
    private boolean cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        campoId = (EditText) findViewById(R.id.EditcampoId);
        campo1 = (EditText) findViewById(R.id.Editcampo1);
        campo2 = (EditText) findViewById(R.id.Editcampo2);
        campo3 = (EditText) findViewById(R.id.Editcampo3);
        campo4 = (EditText) findViewById(R.id.Editcampo4);
        campo5 = (EditText) findViewById(R.id.Editcampo5);
        editarCampos = (Button) findViewById(R.id.btnEditarCampos);
        eliminarCampos = (Button) findViewById(R.id.btnEliminarCampos);
        crearCampos = (Button) findViewById(R.id.btnCrearCampos);
        progressBar = (ProgressBar) findViewById(R.id.progresBarCrud);

        controller = new PHPController(this);

        datosrecibidos = getIntent();
        String accion = datosrecibidos.getStringExtra("accion");

        switch (accion){
            case "11":
                CrearUsuario();
                break;
            case "12":
                CrearImagen();
                break;
            case "13":
                CrearPerfil();
                break;
            case "14":
                CrearComentario();
                break;
            case "15":
                CrearPublicacion();
            case "21":
                EditarEliminarUsuario();
                break;
            case "22":
                EditarEliminarImagen();
                break;
            case "23":
                EditarEliminarPerfil();
                break;
            case "24":
                EditarEliminarComentario();
                break;
            case "25":
                EditarEliminarPublicacion();
        }
    }
    //CREATE
    private void CrearUsuario(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.VISIBLE);
        campo5.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Nombre");
        campo2.setHint("Apellido");
        campo3.setHint("Correo electronico");
        campo4.setHint("Nombre de usuario");
        campo5.setHint("Clave");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = campo1.getText().toString().trim();
                String ape = campo2.getText().toString().trim();
                String cor = campo3.getText().toString().trim();
                String user = campo4.getText().toString().trim();
                String pass = campo5.getText().toString().trim();
                controller.Register(nom, ape, cor, user, pass);
                barraProgreso();
            }
        });
    }

    private void CrearComentario(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Texto");
        campo2.setHint("Id Usuario");
        campo3.setHint("Id Publicacion");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = campo1.getText().toString().trim();
                String user = campo2.getText().toString().trim();
                String post = campo3.getText().toString().trim();
                controller.crearComentario(text, user, post);
                barraProgreso();
            }
        });
    }

    private void CrearImagen(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);
        campo3.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("URL de la imagen");
        campo2.setHint("Descripcion");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = campo1.getText().toString().trim();
                String des = campo2.getText().toString().trim();
                controller.crearImagen(url, des);
                barraProgreso();
            }
        });
    }

    private void CrearPerfil(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Tipo de usuario");
        campo2.setHint("Codigo. 1 para usuario normal, 2 para administrador");
        campo3.setHint("Id usuario");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = campo1.getText().toString().trim();
                String cod = campo2.getText().toString().trim();
                String iduser = campo3.getText().toString().trim();
                controller.crearPerfil(tipo, cod, iduser);
                barraProgreso();
            }
        });
    }

    private void CrearPublicacion(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);
        campo3.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Id Usuario");
        campo2.setHint("Id Imagen");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = campo1.getText().toString().trim();
                String imagenid = campo2.getText().toString().trim();
                controller.crearPublicacion(userid, imagenid);
                barraProgreso();
            }
        });
    }

    //EDIT n DELETE
    private void EditarEliminarUsuario(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.VISIBLE);
        campo5.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("nombre"));
        campo2.setText(datosrecibidos.getStringExtra("apellido"));
        campo3.setText(datosrecibidos.getStringExtra("correo"));
        campo4.setText(datosrecibidos.getStringExtra("username"));
        campo5.setText(datosrecibidos.getStringExtra("password"));

        editarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                String nom = campo1.getText().toString().trim();
                String ape = campo2.getText().toString().trim();
                String cor = campo3.getText().toString().trim();
                String user = campo4.getText().toString().trim();
                String pass = campo5.getText().toString().trim();
                controller.EditUser(id, nom, ape, cor, user, pass);
                barraProgreso();
            }
        });

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeleteUser(id);
                barraProgreso();
            }
        });
    }

    private void EditarEliminarComentario(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("texto"));
        campo2.setText(datosrecibidos.getStringExtra("idpublicacion"));
        campo3.setText(datosrecibidos.getStringExtra("idusuario"));

        editarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                String text = campo1.getText().toString().trim();
                String post = campo2.getText().toString().trim();
                String user = campo3.getText().toString().trim();
                controller.EditComentario(id, text, post, user);
                barraProgreso();
            }
        });

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeleteComentario(id);
                barraProgreso();
            }
        });
    }

    private void EditarEliminarPerfil(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("tipo"));
        campo2.setText(datosrecibidos.getStringExtra("codigo"));
        campo3.setText(datosrecibidos.getStringExtra("idusuario"));

        editarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                String type = campo1.getText().toString().trim();
                String cod = campo2.getText().toString().trim();
                String user = campo3.getText().toString().trim();
                controller.EditPerfil(id, type, cod, user);
                barraProgreso();
            }
        });

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeletePerfil(id);
                barraProgreso();
            }
        });
    }

    private void EditarEliminarImagen(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);
        campo3.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("imagen"));
        campo2.setText(datosrecibidos.getStringExtra("descripcion"));

        editarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                String urlimagen = campo1.getText().toString().trim();
                String description = campo2.getText().toString().trim();
                controller.EditImagen(id, urlimagen, description);
                barraProgreso();
            }
        });

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeleteImagen(id);
                barraProgreso();
            }
        });
    }

    private void EditarEliminarPublicacion(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);
        campo3.setVisibility(View.INVISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("idusuario"));
        campo2.setText(datosrecibidos.getStringExtra("idimagen"));

        editarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                String user = campo1.getText().toString().trim();
                String image = campo2.getText().toString().trim();
                controller.EditPublicacion(id, user, image);
                barraProgreso();
            }
        });

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeletePublicacion(id);
                barraProgreso();
            }
        });
    }

    private void barraProgreso(){
        if(cargando) {
            progressBar.setVisibility(View.GONE);
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
        }
        cargando = !cargando;
    }
}