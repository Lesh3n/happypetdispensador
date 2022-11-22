package com.example.appdispensador;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogConfigComidas extends AppCompatDialogFragment{
    public Button btnAgregarHora;
    public Button btnDialogBorrar;
    public Button btnDialogEditar;

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
}
