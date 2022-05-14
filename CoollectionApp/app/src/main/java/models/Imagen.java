package models;

import java.io.Serializable;

public class Imagen implements Serializable {

    String idimagen;
    String imagen;
    String descripcion;

    public Imagen(String idimagen, String imagen, String descripcion) {
        this.idimagen = idimagen;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Imagen() {
    }

    public String getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(String idimagen) {
        this.idimagen = idimagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "idimagen='" + idimagen + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
