package com.example.coollection;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Comentario;
import models.Imagen;
import models.Perfil;
import models.Publicacion;
import models.Usuario;

public class PHPController {

    Context c;
    RequestQueue requestQueue;

    //private static String IP = "192.168.10.17"; //Casa
    private static String IP = "172.17.2.67"; //USB

    //Usuario URLS
    private static String URLREGISTER = "http://"+IP+"/coollection/usuarios/register.php";
    private static String URLLOGIN = "http://"+IP+"/coollection/usuarios/login.php?";
    private static String URLREADALLUSER = "http://"+IP+"/coollection/usuarios/readAll.php";
    private static String URLEDITUSER = "http://"+IP+"/coollection/usuarios/update.php";
    private static String URLDELETEUSER = "http://"+IP+"/coollection/usuarios/delete.php";
    private static String URLREADUSER = "http://"+IP+"/coollection/usuarios/read.php?id=";

    //Perfil URL
    private static String ULRCREATEPERFIL = "http://"+IP+"/coollection/perfiles/create.php";
    private static String URLREADALLPERFIL = "http://"+IP+"/coollection/perfiles/readAll.php";
    private static String URLEDITPERFIL = "http://"+IP+"/coollection/perfiles/update.php";
    private static String URLDELETEPERFIL = "http://"+IP+"/coollection/perfiles/delete.php";

    //Comentarios URL
    private static String ULRCREATECOMENTARIO = "http://"+IP+"/coollection/comentarios/create.php";
    private static String URLREADALLCOMENTARIO = "http://"+IP+"/coollection/comentarios/readAll.php";
    private static String URLEDITCOMENTARIO = "http://"+IP+"/coollection/comentarios/update.php";
    private static String URLDELETECOMENTARIO = "http://"+IP+"/coollection/comentarios/delete.php";

    //Publicaciones URL
    private static String ULRCREATEPUBLICACIONES = "http://"+IP+"/coollection/publicaciones/create.php";
    private static String URLREADALLPUBLICACIONES = "http://"+IP+"/coollection/publicaciones/readAll.php";
    private static String URLEDITPUBLICACIONES = "http://"+IP+"/coollection/publicaciones/update.php";
    private static String URLDELETEPUBLICACIONES = "http://"+IP+"/coollection/publicaciones/delete.php";

    //Imagenes URL
    private static String ULRCREATEIMAGENES = "http://"+IP+"/coollection/imagenes/create.php";
    private static String URLREADALLIMAGENES = "http://"+IP+"/coollection/imagenes/readAll.php";
    private static String URLEDITIMAGENES = "http://"+IP+"/coollection/imagenes/update.php";
    private static String URLDELETEIMAGENES = "http://"+IP+"/coollection/imagenes/delete.php";

    //Constructor
    public PHPController(Context context){
        c = context;
        requestQueue = Volley.newRequestQueue(c);
    }

    //METODOS
    //Usuarios
    public void ReadUsuario(String id){
        String urlread = URLREADUSER + id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlread,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(c, "EDITAR PERFIL", Toast.LENGTH_SHORT).show();
                        String id, nombre, apellido, correo, username, password;
                        try {
                            id = response.getString("id");
                            nombre = response.getString("nombre");
                            apellido = response.getString("apellido");
                            correo = response.getString("correo");
                            username = response.getString("username");
                            password = response.getString("password");

                            Intent i = new Intent(c, EditarPerfilActivity.class);
                            i.putExtra("usuid", id);
                            i.putExtra("usunombre", nombre);
                            i.putExtra("usuapellido", apellido);
                            i.putExtra("usucorreo", correo);
                            i.putExtra("usuUsername", username);
                            i.putExtra("usuPassword", password);
                            c.startActivity(i);

                        }catch (JSONException e){
                            System.out.println("ERROR: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al cargar perfil...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }

    public void Register(String nom, String ape, String email ,String user, String pass){

        final String nombre = nom;
        final String apellido = ape;
        final String correo = email;
        final String username = user;
        final String password = pass;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLREGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "¡USUARIO REGISTRADO CON EXITO!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al crear al usuario...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("apellido", apellido);
                params.put("correo", correo);
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void Login(String user, String pass){
        String username = "username="+user;
        String password = "&password="+pass;
        String urllogin = URLLOGIN + username + password;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urllogin,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(c, "¡INICIO DE SESION EXITOSA!", Toast.LENGTH_SHORT).show();
                        String id, nombre, apellido, correo, username, password;
                        try {
                            id = response.getString("id");
                            nombre = response.getString("nombre");
                            apellido = response.getString("apellido");
                            correo = response.getString("correo");
                            username = response.getString("username");
                            password = response.getString("password");
                            String nombreCompleto = nombre + " " + apellido;

                            if (id.equals("1")){
                                Intent i = new Intent(c, OpcionesAdminActivity.class);
                                i.putExtra("usuario", nombreCompleto);
                                i.putExtra("usucorreo", correo);
                                i.putExtra("usuUsername", username);
                                i.putExtra("usuPassword", password);
                                c.startActivity(i);
                            }else{
                                crearPerfil(id);
                                Intent i = new Intent(c, OpcionesUsuarioActivity.class);
                                i.putExtra("idusuario", id);
                                i.putExtra("usuario", nombreCompleto);
                                i.putExtra("usucorreo", correo);
                                i.putExtra("usuUsername", username);
                                i.putExtra("usuPassword", password);
                                c.startActivity(i);
                            }

                        }catch (JSONException e){
                            System.out.println("ERROR: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al logearse...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }

    public void ReadAllUsuarios(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLUSER,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Usuario> lista = generarListaUsuarios(response);
                        Intent intent = new Intent(c, MostrarTablaActivity.class);
                        intent.putExtra("tipotabla", "Usuarios");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar usuarios...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Usuario> generarListaUsuarios(JSONArray jsonArray){

        ArrayList<Usuario> listausuarios = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Usuario user = new Usuario();

                user.setId(jsonArray.getJSONObject(i).getString("id"));
                user.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                user.setApellido(jsonArray.getJSONObject(i).getString("apellido"));
                user.setUsername(jsonArray.getJSONObject(i).getString("username"));
                user.setPassword(jsonArray.getJSONObject(i).getString("password"));
                user.setCorreo(jsonArray.getJSONObject(i).getString("correo"));

                System.out.println(jsonArray.get(i).toString());
                listausuarios.add(user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listausuarios.size(); i++) {
            System.out.println(listausuarios.get(i));
        }
        System.out.println("----------------------------------------");

        if (listausuarios.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE USUARIOS ESTA VACIA");
            System.out.println(listausuarios.size());
            System.out.println("----------------------------");
        }

        return listausuarios;

    }

    public void EditUser(String id, String nom, String ape, String email, String user, String pass){
        final String idUser = id;
        final String nombreUser = nom;
        final String apellidoUser = ape;
        final String correoUser = email;
        final String usernameUser = user;
        final String passwordUser = pass;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLEDITUSER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Update Succesful, restarting app to apply changes...", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(c, LoginActivity.class);
                        c.startActivity(i);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Update ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("Update ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idUser);
                params.put("nombre", nombreUser);
                params.put("apellido", apellidoUser);
                params.put("correo", correoUser);
                params.put("username", usernameUser);
                params.put("password", passwordUser);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DeleteUser(String id){
        final String idUser = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETEUSER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idUser);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Perfiles
    private void crearPerfil(String id){
        final String idusuario = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATEPERFIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("PERFIL CREADO CON EXITO");
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO EL PERFIL");
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idusuario", idusuario);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ReadAllPerfiles(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLPERFIL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Perfil> lista = generarListaPerfiles(response);
                        Intent intent = new Intent(c, MostrarTablaActivity.class);
                        intent.putExtra("tipotabla", "Perfiles");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar perfiles...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Perfil> generarListaPerfiles(JSONArray jsonArray){

        ArrayList<Perfil> listaperfiles = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Perfil profile = new Perfil();

                profile.setIdperfil(jsonArray.getJSONObject(i).getString("idperfil"));
                profile.setTipo(jsonArray.getJSONObject(i).getString("tipo"));
                profile.setCodigo(jsonArray.getJSONObject(i).getString("codigo"));
                profile.setIdusuario(jsonArray.getJSONObject(i).getString("idusuario"));

                System.out.println(jsonArray.get(i).toString());
                listaperfiles.add(profile);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listaperfiles.size(); i++) {
            System.out.println(listaperfiles.get(i));
        }
        System.out.println("----------------------------------------");

        if (listaperfiles.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE PERFILES ESTA VACIA");
            System.out.println(listaperfiles.size());
            System.out.println("----------------------------");
        }

        return listaperfiles;

    }

    public void EditPerfil(String id, String type, String cod, String user){

        final String idperfil = id;
        final String tipo = type;
        final String codigo = cod;
        final String idusuario = user;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLEDITPERFIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Update Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Update ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println(error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idperfil);
                params.put("tipo", type);
                params.put("codigo", codigo);
                params.put("idusuario", idusuario);
                return params;
            }
        };

        requestQueue.add(stringRequest);//Enviar la peticion
    }

    public void DeletePerfil(String id){
        final String idPerfil = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETEPERFIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idPerfil);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Comentarios
    private void crearComentario(String text, String user, String post){

        final String texto = text;
        final String idpublicacion = post;
        final String idusuario = user;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATECOMENTARIO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("COMENTARIO CREADO CON EXITO");
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO EL COMENTARIO");
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("texto", texto);
                params.put("idpublicacion", idpublicacion);
                params.put("idusuario", idusuario);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ReadAllComentarios(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLCOMENTARIO,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Comentario> lista = generarListaComentarios(response);
                        Intent intent = new Intent(c, MostrarTablaActivity.class);
                        intent.putExtra("tipotabla", "Comentarios");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar comentarios...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Comentario> generarListaComentarios(JSONArray jsonArray){

        ArrayList<Comentario> listacomentarios = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Comentario comment = new Comentario();

                comment.setIdcomentario(jsonArray.getJSONObject(i).getString("idcomentario"));
                comment.setTexto(jsonArray.getJSONObject(i).getString("texto"));
                comment.setIdpublicacion(jsonArray.getJSONObject(i).getString("idpublicacion"));
                comment.setIdusuario(jsonArray.getJSONObject(i).getString("idusuario"));

                System.out.println(jsonArray.get(i).toString());
                listacomentarios.add(comment);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listacomentarios.size(); i++) {
            System.out.println(listacomentarios.get(i));
        }
        System.out.println("----------------------------------------");

        if (listacomentarios.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE COMENTARIOS ESTA VACIA");
            System.out.println(listacomentarios.size());
            System.out.println("----------------------------");
        }

        return listacomentarios;

    }

    public void EditComentario(String id, String text, String post, String user){

        final String idcomentario = id;
        final String texto = text;
        final String idpublicacion = post;
        final String idusuario = user;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLEDITCOMENTARIO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Update Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Update ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println(error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idcomentario);
                params.put("texto", texto);
                params.put("idpublicacion", idpublicacion);
                params.put("idusuario", idusuario);
                return params;
            }
        };

        requestQueue.add(stringRequest);//Enviar la peticion
    }

    public void DeleteComentario(String id){
        final String idcomentario = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETECOMENTARIO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idcomentario);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Publicaciones
    private void crearPublicacion(String usuario, String imagen){

        final String idusuario = usuario;
        final String idimagen = imagen;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATEPUBLICACIONES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("PUBLICACION CREADO CON EXITO");
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO EL PUBLICACION");
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idusuario", idusuario);
                params.put("idimagen", idimagen);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ReadAllPublicaciones(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLPUBLICACIONES,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Publicacion> lista = generarListaPublicaciones(response);
                        Intent intent = new Intent(c, MostrarTablaActivity.class);
                        intent.putExtra("tipotabla", "Publicaciones");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar publicaciones...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Publicacion> generarListaPublicaciones(JSONArray jsonArray){

        ArrayList<Publicacion> listapublicacion = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Publicacion publication = new Publicacion();

                publication.setIdpublicacion(jsonArray.getJSONObject(i).getString("idpublicacion"));
                publication.setIdusuario(jsonArray.getJSONObject(i).getString("idusuario"));
                publication.setIdimagen(jsonArray.getJSONObject(i).getString("idimagen"));

                System.out.println(jsonArray.get(i).toString());
                listapublicacion.add(publication);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listapublicacion.size(); i++) {
            System.out.println(listapublicacion.get(i));
        }
        System.out.println("----------------------------------------");

        if (listapublicacion.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE PUBLICACIONES ESTA VACIA");
            System.out.println(listapublicacion.size());
            System.out.println("----------------------------");
        }

        return listapublicacion;

    }

    public void EditPublicacion(String id, String user, String image){

        final String idpublicacion = id;
        final String idusuario = user;
        final String idimagen = image;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLEDITPUBLICACIONES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Update Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Update ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println(error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idpublicacion", idpublicacion);
                params.put("idusuario", idusuario);
                params.put("idimagen", idimagen);
                return params;
            }
        };

        requestQueue.add(stringRequest);//Enviar la peticion
    }

    public void DeletePublicacion(String id){
        final String idPublicacion = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETEPUBLICACIONES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idpublicaion", idPublicacion);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Imagenes
    private void crearImagen(String urlimagen, String description){

        final String imagen = urlimagen;
        final String descripcion = description;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATEIMAGENES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("IMAGEN CREADO CON EXITO");
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO EL IMAGEN");
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("imagen", imagen);
                params.put("descripcion", descripcion);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ReadAllImagenes(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLIMAGENES,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Imagen> lista = generarListaImagenes(response);
                        Intent intent = new Intent(c, MostrarTablaActivity.class);
                        intent.putExtra("tipotabla", "Imagenes");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar imagenes...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Imagen> generarListaImagenes(JSONArray jsonArray){

        ArrayList<Imagen> listaimagen = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Imagen image = new Imagen();

                image.setIdimagen(jsonArray.getJSONObject(i).getString("idimagen"));
                image.setImagen(jsonArray.getJSONObject(i).getString("imagen"));
                image.setDescripcion(jsonArray.getJSONObject(i).getString("descripcion"));

                System.out.println(jsonArray.get(i).toString());
                listaimagen.add(image);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listaimagen.size(); i++) {
            System.out.println(listaimagen.get(i));
        }
        System.out.println("----------------------------------------");

        if (listaimagen.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE IMAGENES ESTA VACIA");
            System.out.println(listaimagen.size());
            System.out.println("----------------------------");
        }

        return listaimagen;

    }

    public void EditImagen(String id, String urlimagen, String descripction){

        final String idimagen = id;
        final String imagen = urlimagen;
        final String descripcion = descripction;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLEDITIMAGENES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Update Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Update ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println(error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idimagen", idimagen);
                params.put("imagen", imagen);
                params.put("descripcion", descripcion);
                return params;
            }
        };

        requestQueue.add(stringRequest);//Enviar la peticion
    }

    public void DeleteImagen(String id){
        final String idimagen = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETEIMAGENES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idimagen", idimagen);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
