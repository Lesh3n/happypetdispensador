package com.example.appdispensador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.appdispensador.Modelos.Comidas;
import com.example.appdispensador.cfg.configuracionFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends Fragment {
    List<Comidas> comidas;
    RecyclerView recyclerView;
    comidaAdapter comidaAdapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    public Inicio() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //recyclerView = findViewById(R.id.recyclerView); //Esto tiene el problema
       /* recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new comidaAdapter(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").child("").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new comidaAdapter(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }


    public void btnAlimento (View v){
        Toast.makeText(this.requireActivity(), "Se ha alimentado a la mascota exitosamente.", Toast.LENGTH_SHORT).show();
    }
}