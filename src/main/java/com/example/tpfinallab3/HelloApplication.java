package com.example.tpfinallab3;

import com.example.tpfinallab3.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Docturno®");
        stage.setScene(scene);
        stage.show();
        LoginController loginController = fxmlLoader.getController();
        loginController.setStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    //--------------  ESTO ES PARA GUARDAR LOS DATOS EN UN JSON AL CERRAR LA APP ----------------
  /*  @Override
    public void stop() throws Exception {
        MedicoService.getInstance().guardarMedicosJson();

    }*/

    public static void main(String[] args) {
        launch();
    }
}