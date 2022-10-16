package com.example.appdispensador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class configuracion extends AppCompatActivity {
    Button botonProgramar;
    RadioButton radioProgramado;
    RadioButton radioAutomatico;
    TextView vistaTextoTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        vistaTextoTitulo = (TextView) findViewById(R.id.tituloTb);

        setTitulo("Configuracion");

        botonProgramar = findViewById(R.id.btnAlimento);
        botonProgramar.setEnabled(false);

    }

    public void setTitulo(String title){
        vistaTextoTitulo.setText(title);
    }

    public void cambios(View v){
        EditText campoNombreMascota = this.findViewById(R.id.inNombreMascota);
        String nombreMascota = campoNombreMascota.getText().toString();

        //Agarrar cambios de cantidad de comida a consumir
        EditText campoAlimento = this.findViewById(R.id.inCantidadComida);
        //Integer cantidadAlimento = campoAlimento.getText();

        Intent i = new Intent(this,Inicio.class);
        startActivity(i);
    }

    public void botonRadioChequeado(View vista){
        //El boton esta chequeado?
        boolean chequeado = ((RadioButton) vista).isChecked();
        // Check which radio button was clicked
        switch(vista.getId()) {
            case R.id.radioProgramado:
                if (chequeado)
                    // Desbloquea el boton antes bloqueado
                    botonProgramar.setEnabled(true);
                    break;
            case R.id.radioAutomatico:
                if (chequeado)
                    // Bloquea el boton de programar, no es necesario usarlo.
                    botonProgramar.setEnabled(false);
                    break;
    }


}
}