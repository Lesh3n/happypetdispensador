package com.example.appdispensador.Modelos;

public class Config {
    String idCambio;
    String nombreMascota;
    Integer cantidadAlimento;

    public Config() {
    }


    public Config(String idCambio,String nombreMascota, Integer cantidadAlimento){
        this.idCambio = idCambio;
        this.nombreMascota = nombreMascota;
        this.cantidadAlimento = cantidadAlimento;
    }

    public String getIdCambio(){
        return idCambio;
    }

    public String getNombreMascota(){
        return nombreMascota;
    }

    public Integer getcantidadAlimento(){
        return cantidadAlimento;
    }

}


