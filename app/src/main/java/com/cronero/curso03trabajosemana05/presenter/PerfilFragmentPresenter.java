package com.cronero.curso03trabajosemana05.presenter;

import android.content.Context;

import com.cronero.curso03trabajosemana05.db.ConstructorPerfil;
import com.cronero.curso03trabajosemana05.fragment.IPerfilFragmentView;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<Mascota> fotosPerfil;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context){
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;

        obtenerMascotaPerfilBaseDatos();
    }

    @Override
    public void obtenerMascotaPerfilBaseDatos() {
        constructorPerfil = new ConstructorPerfil(context);
        fotosPerfil = constructorPerfil.obtenerDatosMascotaPerfil();
        mostrarMascotaPerfilRV();
    }

    @Override
    public void mostrarMascotaPerfilRV() {
        iPerfilFragmentView.inicializarAdaptadorRVMascotaPerfil(iPerfilFragmentView.crearAdaptadorMascotaPerfil(fotosPerfil));
        iPerfilFragmentView.generarGridLayoutMascotaPerfil();
    }
}
