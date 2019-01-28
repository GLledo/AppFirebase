package com.example.gonza.appfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);

    }

    public void acceder(View v){

        String usuario = etUsuario.getText().toString();

        if (usuario.trim().equals("")){
            Toast.makeText(getBaseContext(),getString(R.string.toast_bienvenida),Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(this, VentanaBotones.class);
            i.putExtra(getString(R.string.clave_nombre), usuario);
            startActivity(i);
        }
    }
}
