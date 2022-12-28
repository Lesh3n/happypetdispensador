package com.example.appdispensador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


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
    private String nMascota = "Jack";

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
            }

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
    public boolean onOptionsItemSelected(MenuItem item) {
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

}