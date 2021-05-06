package com.example.primerparcial;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioModel implements Serializable {

    private String nombre;
    private String contrasenia;
    private TipoUsuario tipoUsuario;

    public UsuarioModel() {
    }

    public UsuarioModel(String nombre, String contrasenia, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return nombre.equals(that.nombre) &&
                contrasenia.equals(that.contrasenia) &&
                tipoUsuario == that.tipoUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, contrasenia);
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }


}
