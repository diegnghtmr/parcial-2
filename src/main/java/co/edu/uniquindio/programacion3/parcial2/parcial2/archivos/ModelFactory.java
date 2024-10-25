package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import java.util.List;

public class ModelFactory {
    Gestion gestion;

    private static class SingletonHolder {

        private static final ModelFactory eINSTANCE = new ModelFactory();

    }

    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactory() {

        cargarRecursosXML();

        if(gestion == null){
            cargarDatosArchivos();
            PersistenciaUtil.inicializarArchivoXML(gestion);
            cargarRecursosXML();
        }
        guardarRecursosXML();
    }
    private void cargarRecursosXML() {
        gestion = PersistenciaUtil.cargarRecursoGestionXML();
    }
    private void guardarRecursosXML() {
        PersistenciaUtil.guardarRecursoGestionXML(gestion);
    }
    private void cargarDatosArchivos() {
        gestion = new Gestion();
        try {
            PersistenciaUtil.cargarDatosArchivos(gestion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Departamento> obtenerDepartamentos() {
        return gestion.getListaDepartamento();
    }

    public List<Asignación> obtenerAsignaciones() {
        return gestion.getListaAsignación();
    }

    public List<Empleado> obtenerEmpleados() {
        return gestion.getListaEmpleado();
    }

    public List<Proyecto> obtenerInventarios() {
        return gestion.getListaProyecto();
    }

    public boolean agregarAsignacion(Asignación asignación) {
        try {
            gestion.agregarAsignacion(asignación);
            PersistenciaUtil.guardarAsignacionArchivo(asignación, PersistenciaUtil.RUTA_ARCHIVO_ASIGNACION);
            guardarRecursosXML();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

}
