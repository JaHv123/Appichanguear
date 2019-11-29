package com.example.appichanguearfinal;

public class CampoDetail {

    public String Nombre;
    public String Precio;
    public String Direccion;
    public String Distancia;
    public String Horario;
    public String telefono;

    public CampoDetail() {
    }

    public CampoDetail(String nombre, String precio, String direccion, String distancia, String horario, String telefono) {
        Nombre = nombre;
        Precio = precio;
        Direccion = direccion;
        Distancia = distancia;
        Horario = horario;
        this.telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
