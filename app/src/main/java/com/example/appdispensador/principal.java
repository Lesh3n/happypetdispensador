package com.example.appdispensador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class principal extends AppCompatActivity {
    TextView vistaTextoTitulo;
    public String nMascota = "Jack";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Referencia al toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        //Cambiar titulo a tb
        vistaTextoTitulo = (TextView) findViewById(R.id.tituloTb);

        //Referencia al layout
        TabLayout tl = (TabLayout) findViewById(R.id.tablayout);

        //Inicia al fragmento inicio apenas inicia la app.
        Inicio i = new Inicio();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,i).commit();
        setTitulo("Bienvenido dueño de " +nMascota);


        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Codificar cosas a ejecutar cuando le das tap a un tab
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        //llamar al fragmento inicio
                        Inicio i = new Inicio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,i).commit();
                        setTitulo("Bienvenido dueño de " +nMascota);
                        break;
                    case 1:
                        //llamar al fragmento estado
                        Estado e = new Estado();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,e).commit();
                        setTitulo("Estado");
                        break;
                    case 2:
                        //llamar al fragmento historico
                        Historico h = new Historico();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,h).commit();
                        setTitulo("Historico");
                        break;
                }
            } //hasta aqui quede, solo me falta poner las cosas en cada view y conectar actividades nuevas en el menu de 3 puntitos
            // pense que esto iba a estar mas dificil de lo que aparentaba pero no, menos mal... ojala no se ponga tan complicado despues
            // gracias a molchat doma por carrear este trabajo

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void setTitulo(String title){
        vistaTextoTitulo.setText(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Incorporar el menu dentro del activity
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); //Recuperar el ID de la opcion seleccionada.
        if (id == R.id.opConfig){
            Intent i = new Intent(this,configuracion.class);
            startActivity(i);
            getSupportActionBar().setTitle("Configuración del dispositivo");
            //Toast.makeText(this, "Vas a config", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.opAbout){
            Toast.makeText(this, "Vas al about", Toast.LENGTH_SHORT).show();
        }



        return super.onOptionsItemSelected(item);
    }

    public void btnAlimento(View view) {
        Toast.makeText(this,"Se ha alimentado a la mascota exitosamente.", Toast.LENGTH_SHORT).show();
    }

}