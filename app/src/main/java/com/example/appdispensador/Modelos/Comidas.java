package com.example.appdispensador.Modelos;

import java.util.UUID;

public class Comidas {
    String Id;
    String Hora;
    String Estado;


    public Comidas() {
    }


    public Comidas(String Hora,String Estado,String Id){
        this.Id = Id;
        this.Hora = Hora;
        this.Estado = Estado;
    }

    public String getHora(){
        return Hora;
    }

    public String getEstado(){
        return Estado;
    }

    public String getId() {
        return Id;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setId(String id) {
        Id = id;
    }
}