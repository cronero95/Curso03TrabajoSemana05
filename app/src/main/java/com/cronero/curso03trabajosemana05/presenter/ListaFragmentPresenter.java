package com.cronero.curso03trabajosemana05.presenter;

import android.content.Context;

import com.cronero.curso03trabajosemana05.db.ConstructorMascotas;
import com.cronero.curso03trabajosemana05.fragment.IListaFragmentView;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class ListaFragmentPresenter implements IListaFragmentPresenter {

    private IListaFragmentView iListaFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListaFragmentPresenter(IListaFragmentView iListaFragmentView, Context context) {
        this.iListaFragmentView = iListaFragmentView;
        this.context = context;

        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosMascotas();
        motrarMascotasRV();
    }

    @Override
    public void motrarMascotasRV() {
        iListaFragmentView.inicializarAdaptadorRVMascotas(iListaFragmentView.crearAdaptadorMascotas(mascotas));
        iListaFragmentView.generarLinerLayoutMascotas();
    }
}
