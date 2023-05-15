module com.example.seguimiento_14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seguimiento_14 to javafx.fxml;
    exports com.example.seguimiento_14;
    exports com.example.seguimiento_14.controller;
    opens com.example.seguimiento_14.controller to javafx.fxml;
}