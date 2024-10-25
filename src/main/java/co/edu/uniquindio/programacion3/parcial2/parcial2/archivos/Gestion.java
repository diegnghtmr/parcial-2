package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gestion implements Serializable {
    private final String nombre = "Oscar SA";
    private List<Empleado> listaEmpleado = new ArrayList<>();
    private List<Departamento> listaDepartamento = new ArrayList<>();
    private List<Proyecto> listaProyecto = new ArrayList<>();
    private List<Asignación> listaAsignación = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public Gestion(List<Empleado> listaEmpleado, List<Departamento> listaDepartamento,
                   List<Proyecto> listaProyecto, List<Asignación> listaAsignación) {
        this.listaEmpleado = listaEmpleado;
        this.listaDepartamento = listaDepartamento;
        this.listaProyecto = listaProyecto;
        this.listaAsignación = listaAsignación;
    }

    public Gestion() {
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    public List<Asignación> getListaAsignación() {
        return listaAsignación;
    }

    public void setListaAsignación(List<Asignación> listaAsignación) {
        this.listaAsignación = listaAsignación;
    }

    public void agregarAsignacion(Asignación asignación) {
        listaAsignación.add(asignación);
    }
}
