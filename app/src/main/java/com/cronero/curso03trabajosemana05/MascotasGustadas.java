package com.cronero.curso03trabajosemana05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cronero.curso03trabajosemana05.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana05.adapter.MascotasGustadasAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;
import com.cronero.curso03trabajosemana05.presenter.IMascotasGustadasPresenter;
import com.cronero.curso03trabajosemana05.presenter.MascotasGustadasPresenter;

import java.util.ArrayList;

public class MascotasGustadas extends AppCompatActivity implements IMascotasGustadas {

    private Toolbar toolbar;
    private RecyclerView listaMascotasGustadas;
    private IMascotasGustadasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gustadas_mascotas);

        toolbar = findViewById(R.id.toolbarback);
        listaMascotasGustadas = findViewById(R.id.rvMascotasGustadas);
        presenter = new MascotasGustadasPresenter(this, getApplicationContext());

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secundario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_contacto:
                Intent intent02 = new Intent(this, Contacto.class);
                startActivity(intent02);
                break;

            case R.id.menu_acerca:
                Intent intent03 = new Intent(this, Acerca.class);
                startActivity(intent03);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void generarLinerLayoutMascotasGustadas() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasGustadas.setLayoutManager(llm);
    }

    @Override
    public MascotasGustadasAdaptador crearAdaptadorMascotasGustadas(ArrayList<Mascota> mascotasGustadas) {
        MascotasGustadasAdaptador mascotasGustadasAdaptador = new MascotasGustadasAdaptador(mascotasGustadas, this);
        return mascotasGustadasAdaptador;
    }

    @Override
    public void inicializarAdaptadorRVMascotasGustadas(MascotasGustadasAdaptador mascotasGustadasAdaptador) {
        listaMascotasGustadas.setAdapter(mascotasGustadasAdaptador);
    }
}