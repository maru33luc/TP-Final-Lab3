package com.example.tpfinallab3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class AdminViewController {

    @FXML
    private PasswordField actualPasswordEdicionEditarUsuarioField;

    @FXML
    private TextField apellidoEdicionEditarUsuarioField;

    @FXML
    private Label apellidoMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label apellidoMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField apellidoNuevoUsuarioField;

    @FXML
    private AnchorPane barraTituloAdminAnchorPane;

    @FXML
    private AnchorPane barraTituloMostrarEditarUsuarioAnchorPane;

    @FXML
    private AnchorPane barraTituloMostrarEliminarUsuarioAnchorPane1;

    @FXML
    private AnchorPane buscarEditarUsuarioAdminAnchorPane;

    @FXML
    private Button buscarEditarUsuarioButton;

    @FXML
    private Button buscarEliminarUsuarioButton;

    @FXML
    private AnchorPane buscarUsuarioEditarUsuarioAdminAnchorPane1;

    @FXML
    private Button cancelarEditarUsuarioButton;

    @FXML
    private Button cancelarEliminarUsuarioButton;

    @FXML
    private AnchorPane cerrarMostrarEditarUsuarioAdminButton;

    @FXML
    private AnchorPane closeAdminButton;

    @FXML
    private AnchorPane closeUserDeleteAdminButton;

    @FXML
    private PasswordField confirmNewPasswordEdicionEditarUsuarioField;

    @FXML
    private Button confirmarEliminarUsuarioAdminButton;

    @FXML
    private Button confirmarUsuarioEditarUsuarioButton;

    @FXML
    private Label docturnoBarraAdminLabel;

    @FXML
    private AnchorPane edicionEditarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane editarUsuarioAdminAnchorPane;

    @FXML
    private Label editarUsuarioAdminButton;

    @FXML
    private Label eliminarUsuarioAdminButton;

    @FXML
    private Label eliminarUsuarioLabel;

    @FXML
    private TextField emailEdicionEditarUsuarioField;

    @FXML
    private Label emailMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label emailMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField emailNuevoUsuarioField;

    @FXML
    private ChoiceBox<?> especialidadEdicionEditarUsuarioChoiceBox;

    @FXML
    private Label especialidadMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label especialidadMostrarEditarUsuarioAdminLabel1;

    @FXML
    private Label especialidadMostrarEliminarUsuarioAdminLabel;

    @FXML
    private ChoiceBox<?> especialidadNuevoUsuarioChoiceBox;

    @FXML
    private Button guardarEdicionEditarUsuarioButton;

    @FXML
    private Button guardarNuevoUsuarioButton;

    @FXML
    private CheckBox isAdminBuscarEditarUsuarioCheckBox;

    @FXML
    private CheckBox isAdminBuscarEliminarUsuarioCheckBox;

    @FXML
    private CheckBox isAdminNuevoUsuarioCheckBox;

    @FXML
    private CheckBox isMedicoBuscarEditarUsuarioCheckBox;

    @FXML
    private CheckBox isMedicoBuscarEliminarUsuarioCheckBox;

    @FXML
    private CheckBox isMedicoNuevoUsuarioCheckBox;

    @FXML
    private TextField matriculaEdicionEditarUsuarioField;

    @FXML
    private Label matriculaMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label matriculaMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField matriculaNuevoUsuarioField;

    @FXML
    private AnchorPane menuAdminAnchorPane;

    @FXML
    private AnchorPane minimizeAdminButton;

    @FXML
    private Label miperfilAdminButton;

    @FXML
    private ImageView mostrarConfirmNewPasswordEdicionEditarUsuarioButton;

    @FXML
    private ImageView mostrarNewPasswordEdicionEditarUsuarioButton;

    @FXML
    private ImageView mostrarPasswordNuevoUsuarioButton;

    @FXML
    private AnchorPane mostrarUsuarioEditarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane mostrarUsuarioEditarUsuarioAdminAnchorPane1;

    @FXML
    private PasswordField newPasswordEdicionEditarUsuarioField;

    @FXML
    private TextField nombreEdicionEditarUsuarioField;

    @FXML
    private Label nombreMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label nombreMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField nombreNuevoUsuarioField;

    @FXML
    private AnchorPane nuevoUsuarioAdminAnchorPane;

    @FXML
    private Label nuevoUsuarioAdminButton;

    @FXML
    private ImageView ocultarConfirmNewPasswordEdicionEditarUsuarioButton;

    @FXML
    private ImageView ocultarNewPasswordEdicionEditarUsuarioButton;

    @FXML
    private ImageView ocultarPasswordNuevoUsuarioButton;

    @FXML
    private AnchorPane panelAdminAnchorPane;

    @FXML
    private PasswordField passwordNuevoUsuarioField;

    @FXML
    private TextField puestoEdicionEditarUsuarioField;

    @FXML
    private Label puestoEdicionEditarUsuarioLabel;

    @FXML
    private Label puestoMostrarEditarUsuarioAdmin;

    @FXML
    private Label puestoMostrarEditarUsuarioAdmin1;

    @FXML
    private TextField puestoNuevoUsuarioField;

    @FXML
    private Label puestoNuevoUsuarioLabel;

    @FXML
    private Label tipoUsuarioMostrarEditarUsuarioAdminField;

    @FXML
    private Label tipoUsuarioMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField userBuscarEditarUsuarioField;

    @FXML
    private TextField userBuscarEliminarUsuarioField;

    @FXML
    private TextField userNuevoUsuarioField;

    @FXML
    private Label usuarioMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label usuarioMostrarEliminarUsuarioAdminLabel;

    @FXML
    private Label verTurnosAdminButton;

    @FXML
    private AnchorPane vistaAdminAnchorPane;

    @FXML
    void buttonDeleteUserAdmin(KeyEvent event) {

    }

    @FXML
    void buttonEditUserAdmin(KeyEvent event) {

    }

    @FXML
    void buttonMyProfileAdmin(KeyEvent event) {

    }

    @FXML
    void buttonNewUserAdmin(KeyEvent event) {

    }

    @FXML
    void buttonViewAppointmentAdmin(KeyEvent event) {

    }

    @FXML
    void checkIsDoctorSearchDelete(ActionEvent event) {

    }

    @FXML
    void checkIsDoctorSearchEdit(ActionEvent event) {

    }

    @FXML
    void checkNewAdmin(ActionEvent event) {

    }

    @FXML
    void checkNewDoctor(ActionEvent event) {

    }

    @FXML
    void choiceSpecialityNewUser(KeyEvent event) {

    }

    @FXML
    void choiceSpecialityUserEdit(KeyEvent event) {

    }

    @FXML
    void clickCancelUserDelete(ActionEvent event) {

    }

    @FXML
    void clickCancelUserEdit(ActionEvent event) {

    }

    @FXML
    void clickClose(KeyEvent event) {

    }

    @FXML
    void clickCloseShowUserEdit(KeyEvent event) {

    }

    @FXML
    void clickConfirmUserDelete(ActionEvent event) {

    }

    @FXML
    void clickConfirmUserEdit(ActionEvent event) {

    }

    @FXML
    void clickHideConfirmNewPasswordUserEdit(KeyEvent event) {

    }

    @FXML
    void clickHideNewPasswordUserEdit(KeyEvent event) {

    }

    @FXML
    void clickHidePasswordNewUser(KeyEvent event) {

    }

    @FXML
    void clickIsAdminSearchDelete(ActionEvent event) {

    }

    @FXML
    void clickIsAdminSearchEdit(ActionEvent event) {

    }

    @FXML
    void clickMinimize(KeyEvent event) {

    }

    @FXML
    void clickSaveNewUser(ActionEvent event) {

    }

    @FXML
    void clickSaveUserEdit(ActionEvent event) {

    }

    @FXML
    void clickSearchEdit(ActionEvent event) {

    }

    @FXML
    void clickSearchUserDelete(ActionEvent event) {

    }

    @FXML
    void clickShowConfirmNewPasswordUserEdit(KeyEvent event) {

    }

    @FXML
    void clickShowNewPasswordUserEdit(KeyEvent event) {

    }

    @FXML
    void clickShowPasswordNewUser(KeyEvent event) {

    }

    @FXML
    void fielNewPasswordUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldConfirmNewPasswordUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldEmailNewUser(ActionEvent event) {

    }

    @FXML
    void fieldEmailUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldJobEditUser(ActionEvent event) {

    }

    @FXML
    void fieldJobNewUser(ActionEvent event) {

    }

    @FXML
    void fieldLastnameNewUser(ActionEvent event) {

    }

    @FXML
    void fieldLicenseNewUser(ActionEvent event) {

    }

    @FXML
    void fieldLicenseUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldNameNewUser(ActionEvent event) {

    }

    @FXML
    void fieldNameUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldOldPasswoordUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldPasswordNewUser(ActionEvent event) {

    }

    @FXML
    void fieldSurnameUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldUserNewUser(ActionEvent event) {

    }

    @FXML
    void fieldUserSearchDelete(ActionEvent event) {

    }

    @FXML
    void fieldUserSearchEdit(ActionEvent event) {

    }

}
