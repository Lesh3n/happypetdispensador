package com.example.appdispensador;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdispensador.Modelos.Comidas;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class adapterComidaConfig extends RecyclerView.Adapter{

    List<Comidas> comidas;
    Button btnConfigBorrar;
    FirebaseDatabase database;
    Comidas c;




    public adapterComidaConfig(List<Comidas> comidas) {
        this.comidas = comidas;
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.texto_recycler_menu,parent,false);
        ViewHolderClass vhclass = new ViewHolderClass(view);
        return vhclass;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass vhClass = (ViewHolderClass) holder;
        Comidas comida = comidas.get(position);
        vhClass.dialogHora.setText(comida.getHora());

        ((ViewHolderClass) holder).btnConfigBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(((ViewHolderClass) holder).dialogHora.getContext());
                builder.setTitle("¿Estás seguro de borrar esta hora?");
                builder.setMessage("Lo borrado no se puede recuperar.");
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference("Horas").child("3cfffa82-b85a-4e1b-b3fc-4cf03f08ed7f").removeValue();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //No hace nada
                        Toast.makeText(((ViewHolderClass) holder).dialogHora.getContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView dialogHora;
        Button btnConfigBorrar;
        Button btnConfigEditar;

        public ViewHolderClass(View itemView) {
            super(itemView);
            dialogHora = itemView.findViewById(R.id.dialogHora);
            btnConfigBorrar = (Button) itemView.findViewById(R.id.btnConfigBorrar);
        }
    }
}
