module com.example.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;
    opens com.example.app to javafx.fxml;
    exports com.example.app;
}