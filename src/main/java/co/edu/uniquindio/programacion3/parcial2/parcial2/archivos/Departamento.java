package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.io.Serializable;

public class Departamento implements Serializable {
    private String idDepartamento;
    private String nombreDepartamento;
    private String descripcion;
    private String ubicacion;
    private static final long serialVersionUID = 1L;

    public Departamento(String idDepartamento, String nombreDepartamento, String descripcion, String ubicacion) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public Departamento() {
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
