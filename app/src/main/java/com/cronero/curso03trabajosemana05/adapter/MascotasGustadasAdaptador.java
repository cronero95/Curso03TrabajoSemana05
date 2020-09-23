package com.cronero.curso03trabajosemana05.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cronero.curso03trabajosemana05.db.BaseDatos;
import com.cronero.curso03trabajosemana05.pojo.Mascota;
import com.cronero.curso03trabajosemana05.R;

import java.util.ArrayList;

public class MascotasGustadasAdaptador extends RecyclerView.Adapter<MascotasGustadasAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotasGustadasAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Asocia el view con el cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaviewholder, int position) {//asocia cada elemento con su view
        BaseDatos db = new BaseDatos(activity);

        final Mascota mascota = mascotas.get(position);
        mascotaviewholder.imagenCachorro.setImageResource(mascota.getFoto());
        mascotaviewholder.nombreCachorro.setText(mascota.getNombre());
        mascotaviewholder.textoRating.setText(db.obtenerLikeMascota(mascota) + "");
        mascotaviewholder.botonLike.setBackgroundResource(R.drawable.corazonperrolike);
    }

    @Override
    public int getItemCount() {//Cantidad de elementos.
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagenCachorro;
        private ImageButton botonLike;
        private TextView nombreCachorro;
        private TextView textoRating;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenCachorro = itemView.findViewById(R.id.imagenCachorro);
            botonLike = itemView.findViewById(R.id.botonLike);
            nombreCachorro = itemView.findViewById(R.id.nombreCachorro);
            textoRating = itemView.findViewById(R.id.textoRating);
        }
    }
}