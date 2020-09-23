package com.cronero.curso03trabajosemana05.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cronero.curso03trabajosemana05.R;
import com.cronero.curso03trabajosemana05.adapter.MascotaPerfilAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;
import com.cronero.curso03trabajosemana05.presenter.IPerfilFragmentPresenter;
import com.cronero.curso03trabajosemana05.presenter.PerfilFragmentPresenter;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    private IPerfilFragmentPresenter presenter;
    private String[] listaMascotas;
    private TextView textoNombreMascota;
    private RecyclerView fotosMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = getResources().getStringArray(R.array.nombres_cachorros);
        textoNombreMascota = v.findViewById(R.id.textoNombreMascota);
        fotosMascota = v.findViewById(R.id.rvMascotaPerfil);

        textoNombreMascota.setText(listaMascotas[2]);

        presenter = new PerfilFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarGridLayoutMascotaPerfil() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        fotosMascota.setLayoutManager(glm);
    }

    @Override
    public MascotaPerfilAdaptador crearAdaptadorMascotaPerfil(ArrayList<Mascota> fotosMascota) {
        MascotaPerfilAdaptador mascotaPerfilAdaptador = new MascotaPerfilAdaptador(fotosMascota);
        return mascotaPerfilAdaptador;
    }

    @Override
    public void inicializarAdaptadorRVMascotaPerfil(MascotaPerfilAdaptador mascotaPerfilAdaptador) {
        fotosMascota.setAdapter(mascotaPerfilAdaptador);
    }
}