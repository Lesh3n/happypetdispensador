package com.example.appdispensador;

//import androidx.annotation.
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appdispensador.Modelos.Comidas;
import com.example.appdispensador.cfg.configuracionFirebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//TODO: MODIFICAR DATOS EN LA BASE DE DATOS Y BORRARLOS.



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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Poner aquí la invocación del dialog
                dialogEntradaDatos();
            }
        });

        btnConfigBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //borrarRegistro();
            }
        });
    }

    public void mostrarDatos(){
        recyclerView = findViewById(R.id.recyclerConfigComida);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").child("").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new adapterComidaConfig(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }


    //Cambiar nombre a toolbar



    //Dialog de inserción de horas
    public void dialogEntradaDatos(){
        dialogHora dialogoHora = new dialogHora();
        dialogoHora.show(getSupportFragmentManager(), "Dialogo ingreso hora");
    }



    //Mensaje toast editable
    private void mostrarToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


    //Agregar datos



    //Modificar datos




    //Eliminar datos
    public void borrarRegistro(String key){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Horas").child(key);
        //Hacer tarea generica
        Task<Void> mTarea = databaseReference.removeValue();
        mTarea.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                mostrarToast("Datos borrados");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mostrarToast("Fallo el borrado.");
            }
        });
    }
}