package com.cronero.curso03trabajosemana03;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador  extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;


    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Asocia el view con el cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaviewholder, int position) {//asocia cada elemento con su view
        final Mascota mascota = mascotas.get(position);
        mascotaviewholder.imagenCachorro.setImageResource(mascota.getFoto());
        mascotaviewholder.botonLike.setImageResource(mascota.getBotonLike());
        mascotaviewholder.nombreCachorro.setText(mascota.getNombre());
        mascotaviewholder.textoRating.setText(mascota.getRating());

        mascotaviewholder.botonLike.setOnClickListener(new View.OnClickListener() {
            int rating;
            @Override
            public void onClick(View view) {
                rating = Integer.parseInt(mascota.getRating());
                rating ++;
                mascota.setRating("" + rating);
                notifyDataSetChanged();
            }
        });
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
