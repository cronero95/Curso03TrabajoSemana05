package com.cronero.curso03trabajosemana05;

import com.cronero.curso03trabajosemana05.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana05.adapter.MascotasGustadasAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasGustadas {

    public void generarLinerLayoutMascotasGustadas();

    public MascotasGustadasAdaptador crearAdaptadorMascotasGustadas(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRVMascotasGustadas(MascotasGustadasAdaptador mascotasGustadasAdaptador);
}
