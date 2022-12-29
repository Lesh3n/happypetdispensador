package com.example.appdispensador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.appdispensador.Modelos.Comidas;
import com.example.appdispensador.Modelos.Servir;
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
    Button btnAlimentar;

    public Inicio() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Este es el OnCreate de los fragmentos, aquí debe ir everything.

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        btnAlimentar = v.findViewById(R.id.btnAlimentar);
        btnAlimentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarEstado();
            }
        });
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").child("").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new comidaAdapter(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                avisoError();
            }
        });
        return v;
    }


    public void ingresarEstado(){
        Integer alimentar = 1;
        Servir s = new Servir(alimentar);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("alimento");
        myRef.setValue(s);
        Toast.makeText(this.requireActivity(), "Mascota alimentada exitosamente!", Toast.LENGTH_SHORT).show();

    }

    public void avisoError(){
        Toast.makeText(this.requireActivity(), "Hubo un error en la base de datos.", Toast.LENGTH_SHORT).show();
    }


}