package com.cronero.curso03trabajosemana03;

public class Mascota {
    private int foto;
    private int botonLike;
    private String nombre;
    private String rating;

    public Mascota(int foto, int botonLike, String nombre, String rating){
        this.foto = foto;
        this.botonLike = botonLike;
        this.nombre = nombre;
        this.rating = rating;
    }

    public Mascota (int foto, int botonLike, String nombre){
        this.foto = foto;
        this.botonLike = botonLike;
        this.nombre = nombre;
    }

    public int getFoto() { return foto; }
    public void setFoto(int foto) { this.foto = foto; }

    public int getBotonLike() { return botonLike; }
    public void setBotonLike(int botonLike) { this.botonLike = botonLike; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}
