module co.edu.uniquindio.programacion3.parcial2.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindio.programacion3.parcial2.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.parcial2;
    opens co.edu.uniquindio.programacion3.parcial2.parcial2.archivos to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;
}