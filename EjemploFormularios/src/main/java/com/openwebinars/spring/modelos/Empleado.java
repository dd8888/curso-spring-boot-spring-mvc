package com.openwebinars.spring.modelos;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Empleado {

    @Min(value = 0, message = "{empleado.id.mayorquecero}")
    private long id;
    @NotEmpty(message = "{empleado.nombre.notnull}")
    private String nombre;
    @Email(message = "{empleado.email.formato}")
    private String email;
    private String telefono;
    private boolean directivo;
    private String imagen;

    public Empleado() {
    }

    public Empleado(@Min(value = 0, message = "{empleado.id.mayorquecero}") long id, @NotEmpty(message = "{empleado.nombre.notnull}") String nombre, @Email(message = "{empleado.email.formato}") String email, String telefono, boolean directivo, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.directivo = directivo;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
                ", directivo=" + directivo +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
