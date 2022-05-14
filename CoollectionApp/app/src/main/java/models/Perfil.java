package models;

import java.io.Serializable;

public class Perfil implements Serializable {

    String idperfil;
    String tipo;
    String codigo;
    String idusuario;

    public Perfil(String idperfil, String tipo, String codigo, String idusuario) {
        this.idperfil = idperfil;
        this.tipo = tipo;
        this.codigo = codigo;
        this.idusuario = idusuario;
    }

    public Perfil() {
    }

    public String getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(String idperfil) {
        this.idperfil = idperfil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "idperfil='" + idperfil + '\'' +
                ", tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                ", idusuario='" + idusuario + '\'' +
                '}';
    }
}
