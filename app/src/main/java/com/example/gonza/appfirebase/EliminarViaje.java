package com.example.gonza.appfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarViaje extends AppCompatActivity {

    EditText etEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_viaje);

        etEliminar = findViewById(R.id.etEliminarViaje);

    }

    public void eliminar(View v){

        String viajeELi = etEliminar.getText().toString();

        if (viajeELi.trim().equals("")){
            Toast.makeText(getBaseContext(),getString(R.string.toast_eliminar),Toast.LENGTH_LONG).show();
        }else{

            Intent i = new Intent(this, ListaViaje.class);
            i.putExtra("tipoFiltro","borrar");
            i.putExtra(getString(R.string.clave_eliminar),viajeELi);
            startActivity(i);
        }

    }

    public  void atras (View v ){
        Intent i = new Intent(this, VentanaBotones.class);
        startActivity(i);
    }
}
