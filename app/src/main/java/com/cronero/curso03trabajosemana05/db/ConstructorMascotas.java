package com.cronero.curso03trabajosemana05.db;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.cronero.curso03trabajosemana05.R;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosMascotas(){

        BaseDatos db = new BaseDatos(context);

        Boolean isFirstRun = context.getSharedPreferences("PREFERENCE", context.MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            insertarMascotas(db);
        }
        context.getSharedPreferences("PREFERENCE", context.MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

        return db.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        String nombreMascota[] = context.getResources().getStringArray(R.array.nombres_cachorros);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[0]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.bulldog);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[1]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.dalmata);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[2]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.husky);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[3]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.labrador);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[4]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.pastor);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[5]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.pitbull);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, nombreMascota[6]);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PICT, R.drawable.sharpei);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES, LIKE);
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_NAME, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_PICT, mascota.getFoto());
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeMascota(mascota);
    }
}
