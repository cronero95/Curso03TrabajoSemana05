package com.cronero.curso03trabajosemana03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = findViewById(R.id.rvMascotasInicio);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.corazonperrolike, "Lucky", "0"));
        mascotas.add(new Mascota(R.drawable.dalmata, R.drawable.corazonperrolike, "Star", "0"));
        mascotas.add(new Mascota(R.drawable.husky, R.drawable.corazonperrolike, "Snow", "0"));
        mascotas.add(new Mascota(R.drawable.labrador, R.drawable.corazonperrolike, "Buddy", "0"));
        mascotas.add(new Mascota(R.drawable.pastor, R.drawable.corazonperrolike, "Lucy", "0"));
        mascotas.add(new Mascota(R.drawable.pitbull, R.drawable.corazonperrolike, "Max", "0"));
        mascotas.add(new Mascota(R.drawable.sharpei, R.drawable.corazonperrolike, "Molly", "0"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.irFavoritos){
            Intent intent = new Intent(this, MascotasGustadas.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}