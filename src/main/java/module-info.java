module pi.innovatix.innovatix {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens pi.innovatix.innovatix.test to javafx.fxml;
     exports pi.innovatix.innovatix.test;
}