package models;

import java.io.Serializable;

public class Comentario implements Serializable {

    String idcomentario;
    String texto;
    String idpublicacion;
    String idusuario;

    public Comentario(String idcomentario, String texto, String idpublicacion, String idusuario) {
        this.idcomentario = idcomentario;
        this.texto = texto;
        this.idpublicacion = idpublicacion;
        this.idusuario = idusuario;
    }

    public Comentario() {
    }

    public String getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(String idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    @Override
    public String toString() {
        return "Comentario{" +
                "idcomentario='" + idcomentario + '\'' +
                ", texto='" + texto + '\'' +
                ", idpublicacion='" + idpublicacion + '\'' +
                ", idusuario='" + idusuario + '\'' +
                '}';
    }
}
