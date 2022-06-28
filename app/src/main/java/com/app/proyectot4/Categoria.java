package com.app.proyectot4;

import java.util.Objects;

public class Categoria {
    private final String id;
    private final String nombre;
    private final String imagen;

    public Categoria(String id, String nombre, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id) &&
                nombre.equals(categoria.nombre) &&
                imagen.equals(categoria.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, imagen);
    }
}
