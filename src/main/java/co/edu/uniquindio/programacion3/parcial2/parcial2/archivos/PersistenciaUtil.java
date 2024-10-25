package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;



import co.edu.uniquindio.programacion3.parcial2.parcial2.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersistenciaUtil {
    static ResourceBundle config = ResourceBundle.getBundle("archivos/config");
    public static final String RUTA_ARCHIVO_EMPLEADO = config.getString("rutaEmpleado");
    public static final String RUTA_ARCHIVO_DEPARTAMENTO = config.getString("rutaDepartamento");
    public static final String RUTA_ARCHIVO_PROYECTO = config.getString("rutaProyecto");
    public static final String RUTA_ARCHIVO_ASIGNACION = config.getString("rutaAsignacion");
    public static final String RUTA_XML = config.getString("rutaXML");


    public static void cargarDatosArchivos(Gestion gestion) throws FileNotFoundException, IOException{
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
        if (empleadosCargados.size() > 0) {
            gestion.setListaEmpleado(empleadosCargados);
        }

        ArrayList<Departamento> departamentosCargados = cargarDepartamentos();
        if (departamentosCargados.size() > 0) {
            gestion.setListaDepartamento(departamentosCargados);
        }

        ArrayList<Proyecto> proyectosCargados = cargarProyectos();
        if (proyectosCargados.size() > 0) {
            gestion.setListaProyecto(proyectosCargados);
        }

        ArrayList<Asignación> asignacionesCargados = cargarAsignacion();
        if (asignacionesCargados.size() > 0) {
            gestion.setListaAsignación(asignacionesCargados);
        }

    }

    private static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADO);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("\\$\\$");
            String idEmpleado = atributos[0];
            String nombre = atributos[1];
            String apellido = atributos[2];
            String idDepartamento = atributos[3];

            Empleado empleado = new Empleado(idEmpleado, nombre, apellido, idDepartamento);

            empleados.add(empleado);
        }
        return empleados;
    }

    private static ArrayList<Departamento> cargarDepartamentos() throws FileNotFoundException, IOException {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_DEPARTAMENTO);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("\\$\\$");
            String idDepartamento = atributos[0];
            String nombreDepartamento = atributos[1];
            String descripcion = atributos[2];
            String ubicacion = atributos[3];

            Departamento departamento = new Departamento(idDepartamento, nombreDepartamento, descripcion, ubicacion);

            departamentos.add(departamento);
        }
        return departamentos;
    }

    private static ArrayList<Proyecto> cargarProyectos() throws FileNotFoundException, IOException {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROYECTO);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("\\$\\$");
            String idProyecto = atributos[0];
            String nombreProyecto = atributos[1];
            String idDepartamento = atributos[2];

            Proyecto proyecto = new Proyecto(idProyecto, nombreProyecto, idDepartamento);

            proyectos.add(proyecto);
        }
        return proyectos;
    }


    private static ArrayList<Asignación> cargarAsignacion() throws FileNotFoundException, IOException {
        ArrayList<Asignación> asignaciones = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ASIGNACION);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("##");
            String idEmpleado = atributos[0];
            String nombreEmpleado = atributos[1];
            String nombreDepartamento = atributos[2];
            String nombreProyecto = atributos[3];
            String idProyecto = atributos[4];

            Asignación asignación = new Asignación(idEmpleado, nombreEmpleado, nombreDepartamento, nombreProyecto, idProyecto);

            asignaciones.add(asignación);
        }
        return asignaciones;
    }

    public static void guardarAsignacionArchivo(Asignación asignación, String rutaArchivoStockSucursales) throws IOException {
        String content = asignación.getIdEmpleado() + "##" + asignación.getNombreEmpleado() +
                "##" + asignación.getNombreDepartamento() + "##" + asignación.getNombreProyecto() +
                "##" + asignación.getIdProyecto() + "\n";
        ArchivoUtil.guardarArchivo(rutaArchivoStockSucursales, content, true);
    }


    // XML
    public static Gestion cargarRecursoGestionXML() {
        Gestion gestion = null;
        try {
            gestion = (Gestion) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gestion;
    }

    public static void guardarRecursoGestionXML(Gestion gestion) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML, gestion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inicializarArchivoXML(Gestion gestion) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML, gestion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
