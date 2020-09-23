package com.cronero.curso03trabajosemana05.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_PETS_NAME = "mascotas";
    public static final int DATABASE_PETS_VERSION = 1;

    public static final  String TABLE_PETS = "mascotas";
    public static final  String TABLE_PETS_ID = "id";
    public static final  String TABLE_PETS_NAME = "nombre";
    public static final  String TABLE_PETS_PICT = "foto";

    public static final String TABLE_LIKES_PETS = "mascotas_like";
    public static final String TABLE_LIKES_PETS_ID =  "id";
    public static final String TABLE_LIKES_PETS_ID_CONTACTO = "id_mascota";
    public static final String TABLE_LIKES_PETS_NUMERO_LIKES = "likes_mascota";
    public static final String TABLE_LIKES_PETS_NAME = "nombre_mascota";
    public static final String TABLE_LIKES_PETS_PICT = "foto_mascota";

    public static final  String TABLE_PET_PROFILE = "mascota_perfil";
    public static final  String TABLE_PET_PROFILE_ID = "id";
    public static final  String TABLE_PET_PROFILE_PICT = "foto";
}
