module com.example.jsea {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.jsea to javafx.fxml;
    exports com.example.jsea;
}