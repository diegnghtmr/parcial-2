package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.io.Serializable;

public class Proyecto implements Serializable {
    private String idProyecto;
    private String nombreProyecto;
    private String idDepartamento;
    private static final long serialVersionUID = 1L;

    public Proyecto(String idProyecto, String nombreProyecto, String idDepartamento) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.idDepartamento = idDepartamento;
    }

    public Proyecto() {
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
