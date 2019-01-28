package com.example.gonza.appfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VentanaBotones extends AppCompatActivity {

    TextView tvTexto;
    String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_botones);

        tvTexto = findViewById(R.id.txtExplicacion);
        nombre = getIntent().getStringExtra(getString(R.string.clave_nombre));
        tvTexto.setText(String.format(getString(R.string.txt_explicacion),nombre));
    }
}
