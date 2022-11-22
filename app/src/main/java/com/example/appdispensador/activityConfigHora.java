package com.example.appdispensador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appdispensador.Modelos.Comidas;
import com.example.appdispensador.cfg.configuracionFirebase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//TODO: Revisar si muestra datos, falta agregar datos a la base de datos, eliminarlos y modificarlos.
//TODO: También, falta hacer una dialog box con una entrada de texto y un botón para insertar los datos en el firebase.



public class activityConfigHora extends AppCompatActivity {
    FloatingActionButton fab;
    public Button btnConfigBorrar;
    public Button btnConfigEditar;
    //TextView vistaTextoTitulo;
    List<Comidas> comidas;
    RecyclerView recyclerView;
    adapterComidaConfig comidaAdapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_hora);

        mostrarDatos();
        //vistaTextoTitulo = (TextView) findViewById(R.id.tituloTb);

        fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Poner aquí la invocación del dialog
            }
        });*/
    }

    public void mostrarDatos(){
        recyclerView = findViewById(R.id.recyclerConfigComida);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").child("").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new adapterComidaConfig(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Dialog de inserción de horas




    //Agregar datos



    //Modificar datos




    //Eliminar datos
}