package com.cronero.curso03trabajosemana05.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cronero.curso03trabajosemana05.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_PETS_NAME, null, ConstantesBaseDatos.DATABASE_PETS_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //Estructura de la base de datos.
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "("
                + ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_PETS_NAME + " TEXT, "
                + ConstantesBaseDatos.TABLE_PETS_PICT + " INTEGER"
                + ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PETS + "("
                + ConstantesBaseDatos.TABLE_LIKES_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_CONTACTO + " INTEGER, "
                + ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES + " INTEGER, "
                + ConstantesBaseDatos.TABLE_LIKES_PETS_NAME + " TEXT, "
                + ConstantesBaseDatos.TABLE_LIKES_PETS_PICT + " INTEGER,"
                + "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_CONTACTO + ") "
                + "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID + ")"
                + ")";

        String queryCrearTablaMascotaPerfil = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PET_PROFILE + "("
                + ConstantesBaseDatos.TABLE_PET_PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_PET_PROFILE_PICT + " INTEGER"
                + ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL(queryCrearTablaLikesMascota);
        sqLiteDatabase.execSQL(queryCrearTablaMascotaPerfil);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PETS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_PETS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PET_PROFILE);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES + ") as likes"
                    + " FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS
                    + " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_CONTACTO
                    + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PETS, null, contentValues);
        db.close();
    }

    public int obtenerLikeMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES + ")"
                + " FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS
                + " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_CONTACTO
                + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }


    public ArrayList<Mascota> actualizarMascotasGustadas(){
        ArrayList<Mascota> mascotasGustadasActualizadas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS + " ORDER BY "
                + ConstantesBaseDatos.TABLE_LIKES_PETS_ID + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaGustadaNuevaActual = new Mascota();
            mascotaGustadaNuevaActual.setId(registros.getInt(1));
            mascotaGustadaNuevaActual.setRating(registros.getInt(2));
            mascotaGustadaNuevaActual.setNombre(registros.getString(3));
            mascotaGustadaNuevaActual.setFoto(registros.getInt(4));

            mascotasGustadasActualizadas.add(mascotaGustadaNuevaActual);
        }

        db.close();

        return mascotasGustadasActualizadas;
    }

    public ArrayList<Mascota> obtenerMascotaPerfil(){
        ArrayList<Mascota> mascotaPerfil = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET_PROFILE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota fotoActual = new Mascota();
            fotoActual.setId(registros.getInt(0));
            fotoActual.setFoto(registros.getInt(1));

            mascotaPerfil.add(fotoActual);
        }

        db.close();
        return mascotaPerfil;
    }

    public void insertarMascotaPerfil(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PET_PROFILE, null, contentValues);
        db.close();
    }
}
