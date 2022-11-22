package com.example.appdispensador;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdispensador.Modelos.Comidas;
import com.example.appdispensador.cfg.configuracionFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dialogConfigComidas extends AppCompatDialogFragment{
    public Button btnAgregarHora;
    public Button btnDialogBorrar;
    public Button btnDialogEditar;
    List<Comidas> comidas;
    RecyclerView recyclerView;
    adapterComidaDialog comidaAdapter;
    DatabaseReference databaseReference;

    //TODO: Falta recuperar datos de firebase y mostrar los botones junto con la hora configuradas con anterioridad si no hay ninguna desplegar
    //TODO: Mensaje que no hay datos. Además, de ver si se puede abrir la posibilidad a que se abra otra dialog para insertar los datos O poner un recycler con
    //TODO: un campo de texto STRING para poder agregar, cuando se escriban datos y se presione el botón, desaparecer esa recycler hasta que se vuelva a llamar.
    //TODO: Luego mostrarlo por pantalla en el otro recycler.

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_menu,null);
        mostrarDatos(view);
        builder.setView(view)
                .setTitle("Configurar horas de comida")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //No hace nada, simplemente cierra el dialog.
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Acá solo se mostrará un mensaje de horas registradas puesto que al entrar los datos se guardarán automáticamente.

                    }
                });
        return builder.create();
    }

    public void mostrarDatos(View v){
        recyclerView = v.findViewById(R.id.recyclerDialog);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        comidas = new ArrayList<>();
        databaseReference = configuracionFirebase.getFirebaseDatabase();
        databaseReference.child("Horas").child("").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Comidas c = dn.getValue(Comidas.class);
                    comidas.add(c);
                    comidaAdapter = new adapterComidaDialog(comidas);
                    recyclerView.setAdapter(comidaAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
