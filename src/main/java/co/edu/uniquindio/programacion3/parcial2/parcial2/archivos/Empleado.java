package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.io.Serializable;

public class Empleado implements Serializable {
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private String idDepartamento;
    private static final long serialVersionUID = 1L;

    public Empleado(String idEmpleado, String nombre, String apellido, String idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDepartamento = idDepartamento;
    }

    public Empleado() {
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
