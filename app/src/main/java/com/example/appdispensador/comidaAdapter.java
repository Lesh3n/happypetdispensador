package com.example.appdispensador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.appdispensador.Modelos.Comidas;

import java.util.List;

public class comidaAdapter extends RecyclerView.Adapter{

    List<Comidas> comidas;

    public comidaAdapter(List<Comidas> comidas) {
        this.comidas = comidas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textos_comidas,parent,false);
        ViewHolderClass vhclass = new ViewHolderClass(view);
        return vhclass;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass vhClass = (ViewHolderClass) holder;
        Comidas comida = comidas.get(position);
        vhClass.tvHora.setText(comida.getHora());
        vhClass.tvEstado.setText(comida.getEstado());

    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView tvHora;
        TextView tvEstado;

        public ViewHolderClass(View itemView) {
            super(itemView);
            tvHora = itemView.findViewById(R.id.tvHora);
            tvEstado = itemView.findViewById(R.id.tvEstado);
        }
    }
}
