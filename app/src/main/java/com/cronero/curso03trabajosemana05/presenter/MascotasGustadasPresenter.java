package com.cronero.curso03trabajosemana05.presenter;

import android.content.Context;

import com.cronero.curso03trabajosemana05.IMascotasGustadas;
import com.cronero.curso03trabajosemana05.db.ConstructorMascotasGustadas;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class MascotasGustadasPresenter implements IMascotasGustadasPresenter {

    private IMascotasGustadas iMascotasGustadas;
    private Context context;
    private ConstructorMascotasGustadas constructorMascotasGustadas;
    private ArrayList<Mascota> mascotasGustadas;

    public MascotasGustadasPresenter(IMascotasGustadas iMascotasGustadas, Context context){
        this.iMascotasGustadas = iMascotasGustadas;
        this.context = context;

        obtenerMascotasGustadasBaseDatos();
    }

    @Override
    public void obtenerMascotasGustadasBaseDatos() {
        constructorMascotasGustadas = new ConstructorMascotasGustadas(context);
        mascotasGustadas = constructorMascotasGustadas.obtenerDatosMascotasGustadas();

        mostrarMascotasGustadasRV();
    }

    @Override
    public void mostrarMascotasGustadasRV() {
        iMascotasGustadas.inicializarAdaptadorRVMascotasGustadas(iMascotasGustadas.crearAdaptadorMascotasGustadas(mascotasGustadas));
        iMascotasGustadas.generarLinerLayoutMascotasGustadas();
    }
}
