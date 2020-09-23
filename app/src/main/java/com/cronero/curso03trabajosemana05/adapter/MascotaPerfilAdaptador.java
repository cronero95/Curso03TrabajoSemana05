package com.cronero.curso03trabajosemana05.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cronero.curso03trabajosemana05.pojo.Mascota;
import com.cronero.curso03trabajosemana05.R;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> fotosMascota;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas){
        this.fotosMascota = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Asocia el view con el cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaviewholder, int position) {//asocia cada elemento con su view
        final Mascota mascota = fotosMascota.get(position);
        mascotaviewholder.imagenCachorro.setImageResource(mascota.getFoto());
    }

    @Override
    public int getItemCount() {//Cantidad de elementos.
        return fotosMascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagenCachorro;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenCachorro = itemView.findViewById(R.id.imagenCachorro);
        }
    }
}
