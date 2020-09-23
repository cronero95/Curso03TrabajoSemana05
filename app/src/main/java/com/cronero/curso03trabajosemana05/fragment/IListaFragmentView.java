package com.cronero.curso03trabajosemana05.fragment;

import com.cronero.curso03trabajosemana05.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public interface IListaFragmentView {

    public void generarLinerLayoutMascotas();

    public MascotaAdaptador crearAdaptadorMascotas(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRVMascotas(MascotaAdaptador mascotaAdaptador);
}
