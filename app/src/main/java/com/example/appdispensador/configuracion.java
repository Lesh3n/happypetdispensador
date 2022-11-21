package com.example.appdispensador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdispensador.Modelos.Config;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class configuracion extends AppCompatActivity {
    Button botonProgramar,btnAplicar;
    EditText etNombre,etComida;
    RadioButton radioProgramado;
    RadioButton radioAutomatico;
    TextView vistaTextoTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        vistaTextoTitulo = (TextView) findViewById(R.id.tituloTb);

        //Id campos
        etNombre = (EditText) this.findViewById(R.id.inNombreMascota);
        etComida = (EditText) this.findViewById(R.id.inCantidadComida);

        setTitulo("Configuracion");

        //BOTONES
        botonProgramar = findViewById(R.id.btnAlimento);
        botonProgramar.setEnabled(false);

        //Boton aplicar
        btnAplicar = (Button) findViewById(R.id.btnAplicar);
        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(configuracion.this, "Cambios guardados.", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });

    }

    public void setTitulo(String title) {

        vistaTextoTitulo.setText(title);

    }

    public void insertar(){
        //Agarra los cambios realizados en los campos
        //QUEDE AQUÍ
        String id = "c1";
        String nombre = etNombre.getText().toString();
        int cantAlimento = Integer.parseInt(etComida.getText().toString());
        Config c = new Config(id,nombre,cantAlimento);

        //Inserción a bdd
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("Configuracion");
        myRef.child(id).setValue(c);

        //Cerrar activity
        finish();
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