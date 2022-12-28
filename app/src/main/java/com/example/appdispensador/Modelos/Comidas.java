package com.example.appdispensador.Modelos;

import java.util.UUID;

public class Comidas {
    String key;
    String Hora;
    String Estado;


    public Comidas() {
    }


    public Comidas(String key,String Hora,String Estado){
        this.key = key;
        this.Hora = Hora;
        this.Estado = Estado;
    }

    public String getHora(){
        return Hora;
    }

    public String getEstado(){
        return Estado;
    }

    public String getKey() {
        return key;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setKey(String key) {
        key = key;
    }
}