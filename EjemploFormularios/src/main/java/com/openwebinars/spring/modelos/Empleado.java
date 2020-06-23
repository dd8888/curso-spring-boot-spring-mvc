package com.openwebinars.spring.modelos;


public class Empleado {

    private long id;
    private String nombre;
    private String email;
    private String telefono;
    private boolean directivo;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String email, String telefono, boolean directivo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.directivo = directivo;
    }

    public boolean isDirectivo() {
        return directivo;
    }

    public void setDirectivo(boolean directivo) {
        this.directivo = directivo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", directivo='" + directivo + '\'' +
                '}';
    }
}
