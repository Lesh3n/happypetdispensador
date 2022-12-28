package com.example.appdispensador;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.appdispensador.Modelos.Comidas;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.UUID;

public class dialogHora extends AppCompatDialogFragment {
    EditText editTextHora;
    FirebaseDatabase db;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view)
                .setTitle("Ingresa la hora a programar")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ingresarDatos();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //No hace nada, simplemente se cierra
                    }
                });
        editTextHora = view.findViewById(R.id.campoIngresoHora);

        return builder.create();
    }


    //Ingresar datos
    private void ingresarDatos(){
        String key = UUID.randomUUID().toString();
        String hora = editTextHora.getText().toString();
        String estado = "Sin servir";
        Comidas c = new Comidas(key,hora,estado);


        db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Horas");
        ref.child(key).setValue(c);
    }
}
