package com.example.appdispensador.Modelos;

public class Comidas {
    String Hora;
    String Estado;


    public Comidas() {
    }


    public Comidas(String Hora,String Estado){
        this.Hora = Hora;
        this.Estado = Estado;
    }

    public String getHora(){
        return Hora;
    }

    public String getEstado(){
        return Estado;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}