package com.ulp.myapprecuperatorio1.Model;
public class Inmueble {
    private String codigo;
    private String descripcion;
    private int cantAmbientes;
    private String direccion;
    private double precio;

    public Inmueble(String codigo, String descripcion, int cantAmbientes, String direccion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantAmbientes = cantAmbientes;
        this.direccion = direccion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Compara la referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica null y tipo

        Inmueble inmueble = (Inmueble) obj; // Realiza el casting
        return codigo.equals(inmueble.codigo); // Compara el código
    }

    @Override
    public int hashCode() {
        return codigo.hashCode(); // Utiliza el código para generar el hash
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nDescripción: " + descripcion +
                "\nAmbientes: " + cantAmbientes + "\nDirección: " + direccion +
                "\nPrecio: " + precio;
    }
}
