package com.example.gonza.appfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.gonza.appfirebase.javabeans.Viaje;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertarViaje extends AppCompatActivity {

    EditText etNombre;
    EditText etPais;
    EditText etCiudad;
    EditText etPrecio;
    EditText etDias;
    String nombre;

    private DatabaseReference dbR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_viaje);

        etNombre = findViewById(R.id.etNombre);
        etPais = findViewById(R.id.etPais);
        etPrecio = findViewById(R.id.etPrecio);
        etCiudad = findViewById(R.id.etCiudad);
        etDias = findViewById(R.id.etDuracion);

        nombre = ((MyApp)getApplicationContext()).getNombre();

        dbR = FirebaseDatabase.getInstance().getReference().child("viaje");

    }

    public void crearViaje(View v){

       Viaje msj = new Viaje(etNombre.getText().toString(),Double.parseDouble(etPrecio.getText().toString()),
               Integer.parseInt(etDias.getText().toString()),etCiudad.getText().toString(),etPais.getText().toString(),nombre);
        String clave = dbR.push().getKey();
        dbR.child(clave).setValue(msj);

        etNombre.setText("");
        etCiudad.setText("");
        etPrecio.setText("");
        etPais.setText("");
        etDias.setText("");
    }
}
