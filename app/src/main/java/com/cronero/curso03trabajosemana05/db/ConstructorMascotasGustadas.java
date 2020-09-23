package com.cronero.curso03trabajosemana05.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cronero.curso03trabajosemana05.R;
import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotasGustadas {

    private Context context;

    public ConstructorMascotasGustadas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosMascotasGustadas(){

        BaseDatos db = new BaseDatos(context);
        /*
        return db.obtenerMascotasGustadas();
        */
        return db.actualizarMascotasGustadas();
    }
}
