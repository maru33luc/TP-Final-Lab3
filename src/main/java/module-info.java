module com.example.tpfinallab3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires jbcrypt;
    requires com.fasterxml.jackson.core;

    exports com.example.tpfinallab3; // Exporta el paquete principal
    exports com.example.tpfinallab3.controllers; // Exporta el paquete de los controladores
    // Agrega otras declaraciones de exportación si tienes más paquetes que necesitan ser accedidos por otros módulos
    // necesito que el paquete de resources sea accesible por el módulo de controllers




    opens com.example.tpfinallab3.controllers to javafx.fxml; // Abre el paquete de los controladores para la reflexión de JavaFX
    opens com.example.tpfinallab3.models to com.fasterxml.jackson.databind;
    exports com.example.tpfinallab3.models to com.fasterxml.jackson.databind;

    opens com.example.tpfinallab3 to javafx.fxml;

}