package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.io.Serializable;

public class Asignación implements Serializable {
    private String idEmpleado;
    private String nombreEmpleado;
    private String nombreDepartamento;
    private String nombreProyecto;
    private String idProyecto;
    private static final long serialVersionUID = 1L;

    public Asignación(String idEmpleado, String nombreEmpleado, String nombreDepartamento,
                      String nombreProyecto, String idProyecto) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreDepartamento = nombreDepartamento;
        this.nombreProyecto = nombreProyecto;
        this.idProyecto = idProyecto;
    }

    public Asignación() {
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }
}
