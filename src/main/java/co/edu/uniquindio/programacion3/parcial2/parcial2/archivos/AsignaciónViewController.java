package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class AsignaciónViewController {
    ModelFactory modelFactory;
    ObservableList<Asignación> listaAsignación = FXCollections.observableArrayList();
    Asignación asignaciónSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<Empleado> cbIdEmpleado;

    @FXML
    private ComboBox<Departamento> cbNombreDepartamento;

    @FXML
    private ComboBox<Proyecto> cbNombreProyecto;

    @FXML
    private TableView<Asignación> tblAsignacion;

    @FXML
    private TableColumn<Asignación, String> tcIdEmpleado;

    @FXML
    private TableColumn<Asignación, String> tcIdProyecto;

    @FXML
    private TableColumn<Asignación, String> tcNombreDepartamento;

    @FXML
    private TableColumn<Asignación, String> tcNombreEmpleado;

    @FXML
    private TableColumn<Asignación, String> tcNombreProyecto;

    @FXML
    private TextField txtIdProyecto;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    void onAgregar(ActionEvent event) {
        agregarAsignacion();
    }

    @FXML
    void onNuevo(ActionEvent event) {
        limpiarCampos();
        deseleccionarTabla();
    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        initView();
        txtIdProyecto.setEditable(false);
        txtNombreEmpleado.setEditable(false);
    }

    private void initView() {
        initDataBinding();
        obtenerAsignaciones();
        cargarDatosComboBox();
        tblAsignacion.getItems().clear();
        tblAsignacion.setItems(listaAsignación);
        listenerSelection();
    }

    private void initDataBinding() {
        tcIdEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdEmpleado()));
        tcIdProyecto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdProyecto())));
        tcNombreDepartamento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreDepartamento()));
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEmpleado()));
        tcNombreProyecto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreProyecto())));
    }

    private void obtenerAsignaciones() {
        listaAsignación.addAll(modelFactory.obtenerAsignaciones());
    }

    private void cargarDatosComboBox() {
        ObservableList<Empleado> empleados = FXCollections.observableArrayList(modelFactory.obtenerEmpleados());
        ObservableList<Departamento> departamentos = FXCollections.observableArrayList(modelFactory.obtenerDepartamentos());
        ObservableList<Proyecto> proyectos = FXCollections.observableArrayList(modelFactory.obtenerInventarios());

        initializeComboBox(cbIdEmpleado, empleados, Empleado::getIdEmpleado);
        initializeComboBox(cbNombreDepartamento, departamentos, Departamento::getNombreDepartamento);
        initializeComboBox(cbNombreProyecto, proyectos, Proyecto::getNombreProyecto);

        cbNombreProyecto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtIdProyecto.setText(String.valueOf(newSelection.getIdProyecto()));
            } else {
                txtIdProyecto.clear();
            }
        });

        cbIdEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtNombreEmpleado.setText(String.valueOf(newSelection.getNombre()));
            } else {
                txtNombreEmpleado.clear();
            }
        });
    }

    private <T> void initializeComboBox(ComboBox<T> comboBox,
                                        ObservableList<T> items,
                                        Function<T, String> displayFunction) {
        comboBox.setItems(items);
        comboBox.setCellFactory(lv -> new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
        comboBox.setButtonCell(new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
    }

    private void listenerSelection() {
        tblAsignacion.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                                 oldSelection, newSelection) -> {
           asignaciónSeleccionado = newSelection;
            mostrarInformacionStockSucursal(asignaciónSeleccionado);
        });
    }

    private void mostrarInformacionStockSucursal(Asignación asignaciónSeleccionado) {
        if (asignaciónSeleccionado != null) {
            txtNombreEmpleado.setText(asignaciónSeleccionado.getNombreEmpleado());
            txtIdProyecto.setText(asignaciónSeleccionado.getIdProyecto());
            cbIdEmpleado.getSelectionModel().select(
                    cbIdEmpleado.getItems().stream()
                            .filter(empleado -> empleado.getIdEmpleado().equals(asignaciónSeleccionado.getIdEmpleado()))
                            .findFirst()
                            .orElse(null)
            );
            cbNombreDepartamento.getSelectionModel().select(
                    cbNombreDepartamento.getItems().stream()
                            .filter(departamento -> departamento.getNombreDepartamento().equals(asignaciónSeleccionado.getNombreDepartamento()))
                            .findFirst()
                            .orElse(null)
            );
            cbNombreProyecto.getSelectionModel().select(
                    cbNombreProyecto.getItems().stream()
                            .filter(proyecto -> proyecto.getNombreProyecto().equals(asignaciónSeleccionado.getNombreProyecto()))
                            .findFirst()
                            .orElse(null)
            );
        }
    }

    private void agregarAsignacion() {
        Asignación asignación = construirAsignacion();
        if (validarDatos(asignación)) {
            if (modelFactory.agregarAsignacion(asignación)) {
                listaAsignación.add(asignación);
                limpiarCampos();
                mostrarMensaje("Información", "Asignación agregada",
                        "La asignación ha sido agregada correctamente.", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Asignación no agregada",
                        "La asignación no ha sido agregada correctamente.", Alert.AlertType.ERROR);
            }
        }
    }

    private Asignación construirAsignacion() {
        Empleado selectedEmpleado = cbIdEmpleado.getSelectionModel().getSelectedItem();
        Departamento selectedDepartamento = cbNombreDepartamento.getSelectionModel().getSelectedItem();
        Proyecto selectedProyecto = cbNombreProyecto.getSelectionModel().getSelectedItem();

        String idEmpleado = selectedEmpleado != null ? selectedEmpleado.getIdEmpleado() : "";
        String nombreEmpleado = txtNombreEmpleado.getText();
        String nombreDepartamento = selectedDepartamento != null ? selectedDepartamento.getNombreDepartamento() : "";
        String nombreProyecto = selectedProyecto != null ? selectedProyecto.getNombreProyecto() : "";
        String idProyecto = txtIdProyecto.getText();

        return new Asignación(idEmpleado, nombreEmpleado, nombreDepartamento, nombreProyecto, idProyecto);
    }

    private boolean validarDatos(Asignación asignación) {
        if (asignación.getIdEmpleado().isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo ID Empleado no puede estar vacío.", Alert.AlertType.ERROR);
            return false;
        }
        if (asignación.getNombreEmpleado().isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo Nombre Empleado no puede estar vacío.", Alert.AlertType.ERROR);
            return false;
        }
        if (asignación.getNombreDepartamento().isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo Nombre Departamento no puede estar vacío.", Alert.AlertType.ERROR);
            return false;
        }
        if (asignación.getNombreProyecto().isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo Nombre Proyecto no puede estar vacío.", Alert.AlertType.ERROR);
            return false;
        }
        if (asignación.getIdProyecto().isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo ID Proyecto no puede estar vacío.", Alert.AlertType.ERROR);
            return false;
        }

        return true;
    }

    public void limpiarCampos() {
        txtIdProyecto.clear();
        txtNombreEmpleado.clear();
        cbNombreDepartamento.getSelectionModel().clearSelection();
        cbIdEmpleado.getSelectionModel().clearSelection();
        cbNombreProyecto.getSelectionModel().clearSelection();
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void deseleccionarTabla() {
        tblAsignacion.getSelectionModel().clearSelection();
        asignaciónSeleccionado = null;
    }


}
