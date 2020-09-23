package com.cronero.curso03trabajosemana05.db;

import android.content.ContentValues;
import android.content.Context;

import com.cronero.curso03trabajosemana05.R;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorPerfil {

    private Context context;

    public ConstructorPerfil(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosMascotaPerfil(){

        BaseDatos db = new BaseDatos(context);

        Boolean isThirdRun = context.getSharedPreferences("PREFERENCE", context.MODE_PRIVATE)
                .getBoolean("isThirdRun", true);

        if (isThirdRun) {
            insertarMascotaPerfil(db);
        }
        context.getSharedPreferences("PREFERENCE", context.MODE_PRIVATE).edit().putBoolean("isThirdRun", false).commit();

        return db.obtenerMascotaPerfil();
    }

    public void insertarMascotaPerfil(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_01);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_02);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_03);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_04);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_05);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_06);
        db.insertarMascotaPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PROFILE_PICT, R.drawable.snow_07);
        db.insertarMascotaPerfil(contentValues);
    }
}
