package com.example.gonza.appfirebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gonza.appfirebase.javabeans.MensajeAdaptador;
import com.example.gonza.appfirebase.javabeans.Viaje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListaViaje extends AppCompatActivity {

   // EditText etMensaje;
    //Button btnEnviar;
    RecyclerView rvViajes;
    MensajeAdaptador adapter;
    LinearLayoutManager llm;
    ArrayList<Viaje> datos;
    String dias;
    private DatabaseReference dbR;
    private ChildEventListener cel;

    private String remitente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viaje);


        // RECOGEMOS EL FILTRO DE LA CONSULTA, DISEñADO PARA UNA AMPLICACIÓN
        String tipoFiltro = getIntent().getStringExtra("tipoFiltro");
        if(tipoFiltro.equals("dias")){
            dias = getIntent().getStringExtra("filtro");
        }
        //Con el string dias filtramos en la lista cuando se carguen los datos
        remitente = "ANONIMO";//TODO AQUI DEBERIA IR EL NOMBRE DEL QUE HA INICIADO LA APLICACION

      //  etMensaje = findViewById(R.id.etMensaje);
      //  btnEnviar = findViewById(R.id.btnEnviar);
        rvViajes = findViewById(R.id.recicledViewListaViajes);

        datos = new ArrayList<Viaje>();
        adapter = new MensajeAdaptador(datos);
        llm = new LinearLayoutManager(this);

        rvViajes.setLayoutManager(llm);
        rvViajes.setAdapter(adapter);
        rvViajes.setItemAnimator(new DefaultItemAnimator());

        dbR = FirebaseDatabase.getInstance().getReference().child("viaje");

        addChildEventListener();

    }

    private void addChildEventListener() {
        if (cel == null) {
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Nuevo mensaje");
                    Viaje m = dataSnapshot.getValue(Viaje.class);

                    if(m.getDuracion()>5) {
                        datos.add(m);
                        adapter.notifyItemInserted(datos.size()-1);
                    }

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Mensaje modificado");
                    Viaje m = dataSnapshot.getValue(Viaje.class);

                    int pos = 0;
                    for (int i = 0; i < datos.size(); i++) {
                        if (datos.get(i).getDestino().equals(m.getDestino())) {
                            datos.set(i, m);
                            pos = i;
                        }
                    }
                    adapter.notifyItemChanged(pos);
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    System.out.println("Mensaje borrado: "
                            + dataSnapshot.getValue(Viaje.class).getDestino());
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

            dbR.addChildEventListener(cel);
        }
    }

  /*  public void enviar(View v) {
        Mensaje msj = new Mensaje(etMensaje.getText().toString(), remitente);
        String clave = dbR.push().getKey();
        dbR.child(clave).setValue(msj);

        etMensaje.setText("");

    }*/

    /*public void aniadir(View v) {
        Mensaje msj = new Mensaje("Bienvenido a Firebase", remitente);
        dbR.child("Bienvenida").setValue(msj);
    }*/

  /*  public void modificar(View v) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Bienvenida/remitente",null);
        mapa.put("Despedida", new Mensaje("Hasta pronto!", null));
        dbR.updateChildren(mapa);
    }*/

 /*   public void borrar(View v) {
        dbR.removeValue();
        adapter.clear();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        if (cel != null) {
            dbR.removeEventListener(cel);
            cel = null;
        }
        adapter.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addChildEventListener();
    }
}