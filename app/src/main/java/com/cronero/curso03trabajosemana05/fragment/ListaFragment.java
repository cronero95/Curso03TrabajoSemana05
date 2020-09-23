package com.cronero.curso03trabajosemana05.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronero.curso03trabajosemana05.R;
import com.cronero.curso03trabajosemana05.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana05.pojo.Mascota;
import com.cronero.curso03trabajosemana05.presenter.IListaFragmentPresenter;
import com.cronero.curso03trabajosemana05.presenter.ListaFragmentPresenter;

import java.util.ArrayList;

public class ListaFragment extends Fragment implements IListaFragmentView {

    private RecyclerView listaMascotas;
    private IListaFragmentPresenter presenter;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        listaMascotas = v.findViewById(R.id.rvMascotasInicio);
        presenter = new ListaFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinerLayoutMascotas() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptadorMascotas(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, getActivity());
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRVMascotas(MascotaAdaptador mascotaAdaptador) {
        listaMascotas.setAdapter(mascotaAdaptador);
    }
}