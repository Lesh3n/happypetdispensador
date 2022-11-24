
//TODO CAMBIAR  O BORRAR ESTA CLASE PORQUE YA NO SIRVE PARA NADA


/*package com.example.appdispensador;

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

public class dialogBorrar extends AppCompatDialogFragment {
    FirebaseDatabase db;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view)
                .setTitle("Eliminar hora")
                .setMessage("¿Desea eliminar la hora seleccionada?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //db.getInstance().getReference().child("Horas")
                                //.child()
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //No hace nada, simplemente se cierra y no borra los datos
                    }
                });

        return builder.create();
    }



}
*/