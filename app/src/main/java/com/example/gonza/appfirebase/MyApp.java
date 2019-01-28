package com.example.gonza.appfirebase;

import android.app.Application;

public class MyApp extends Application {
    String nombre;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
