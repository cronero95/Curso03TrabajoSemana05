package com.cronero.curso03trabajosemana05.fragment;

import com.cronero.curso03trabajosemana05.adapter.MascotaPerfilAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public void generarGridLayoutMascotaPerfil();

    public MascotaPerfilAdaptador crearAdaptadorMascotaPerfil(ArrayList<Mascota> fotosMascota);

    public void inicializarAdaptadorRVMascotaPerfil(MascotaPerfilAdaptador mascotaPerfilAdaptador);
}
