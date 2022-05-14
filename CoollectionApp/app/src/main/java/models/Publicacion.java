package models;

import java.io.Serializable;

public class Publicacion implements Serializable {

    String idpublicacion;
    String idusuario;
    String idimagen;

    public Publicacion(String idpublicacion, String idusuario, String idimagen) {
        this.idpublicacion = idpublicacion;
        this.idusuario = idusuario;
        this.idimagen = idimagen;
    }

    public Publicacion() {
    }

    public String getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(String idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(String idimagen) {
        this.idimagen = idimagen;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "idpublicacion='" + idpublicacion + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", idimagen='" + idimagen + '\'' +
                '}';
    }
}
