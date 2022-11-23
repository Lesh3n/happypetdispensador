package com.example.appdispensador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdispensador.Modelos.Comidas;

import java.util.List;

public class adapterComidaConfig extends RecyclerView.Adapter{

    List<Comidas> comidas;

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

    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView dialogHora;

        public ViewHolderClass(View itemView) {
            super(itemView);
            dialogHora = itemView.findViewById(R.id.dialogHora);
        }
    }
}
