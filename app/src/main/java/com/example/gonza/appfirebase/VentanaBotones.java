package com.example.gonza.appfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VentanaBotones extends AppCompatActivity {

    TextView tvTexto;
    String nombre ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_botones);

        tvTexto = findViewById(R.id.txtExplicacion);
        nombre = ((MyApp)getApplicationContext()).getNombre();
        tvTexto.setText(String.format(getString(R.string.txt_explicacion),nombre));
    }


    public void insertarViaje(View view) {

        Intent i = new Intent(this,InsertarViaje.class);
        startActivity(i);
    }

    public void modificarViaje(View view) {
    }

    public void consultarTodosLosViajes(View view) {
        Intent x = new Intent(this, ListaViaje.class);
        startActivity(x);
    }

    public void consultarViajes5Dias(View view) {
    }
    public void eliminarViaje(View view) {
    }
    public void salir(View view) {

        finish();
    }
}
