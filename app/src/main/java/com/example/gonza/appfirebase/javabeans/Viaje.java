package com.example.gonza.appfirebase.javabeans;

public class Viaje {
    private String destino;
    private Double precio;
    private int duracion;
    private String ciudad;
    private String pais;


    public Viaje() {
    }

    public Viaje(String destino, Double precio, int duracion, String ciudad, String pais) {
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getDestino() {
        return destino;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
