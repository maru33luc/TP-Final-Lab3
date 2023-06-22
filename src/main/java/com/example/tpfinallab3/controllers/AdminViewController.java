package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.security.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminViewController {

    @FXML
    private TextField BuscarVerTurnoAdminField;

    @FXML
    private Label IngreseFechaVerTurnosAdminLabel;

    @FXML
    private Label IngreseMedicoVerTurnosAdminLabel;

    @FXML
    private Label IngresePacienteVerTurnosAdminLabel;

    @FXML
    private AnchorPane verTurnosAdminAnchorPane;

    @FXML
    private PasswordField actualPasswordEdicionEditarUsuarioAdminField;

    @FXML
    private PasswordField actualPasswordEdicionMiPerfilAdminField;

    @FXML
    private TextField apellidoEdicionEditarUsuarioAdminField;

    @FXML
    private TextField apellidoEdicionMiPerfilAdminField;

    @FXML
    private Label apellidoMiPerfilAdminLabel;

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
    private AnchorPane barraTituloMostrarEliminarUsuarioAnchorPane;

    @FXML
    private AnchorPane buscarEditarUsuarioAdminAnchorPane;

    @FXML
    private Button buscarEditarUsuarioButton;

    @FXML
    private AnchorPane buscarEliminarUsuarioAdminAnchorPane;

    @FXML
    private Button buscarEliminarUsuarioButton;

    @FXML
    private AnchorPane buscarVerTurnosAdminAnchorPane;

    @FXML
    private Button buscarVerTurnosAdminButton;

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
    private PasswordField confirmNewPasswordEdicionEditarUsuarioAdminField;

    @FXML
    private PasswordField confirmNewPasswordEdicionMiPerfilAdminField;

    @FXML
    private Button confirmarEliminarUsuarioAdminButton;

    @FXML
    private Button confirmarUsuarioEditarUsuarioButton;

    @FXML
    private Label docturnoBarraAdminLabel;

    @FXML
    private AnchorPane edicionEditarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane editarMiPerfilAdminAnchorPane;

    @FXML
    private Button editarMiPerfilAdminButton;

    @FXML
    private AnchorPane editarUsuarioAdminAnchorPane;

    @FXML
    private Label editarUsuarioAdminButton;

    @FXML
    private AnchorPane eliminarUsuarioAdminAnchorPane;

    @FXML
    private Label eliminarUsuarioAdminButton;

    @FXML
    private Label eliminarUsuarioLabel;

    @FXML
    private TextField emailEdicionEditarUsuarioAdminField;

    @FXML
    private TextField emailEdicionMiPerfilAdminField;

    @FXML
    private Label emailMiPerfilAdminLabel;

    @FXML
    private Label emailMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label emailMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField emailNuevoUsuarioField;

    @FXML
    private ChoiceBox<?> especialidadEdicionEditarUsuarioAdminChoiceBox;

    @FXML
    private Label especialidadMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label especialidadMostrarEliminarUsuarioAdminLabel;

    @FXML
    private ChoiceBox<?> especialidadNuevoUsuarioChoiceBox;

    @FXML
    private CheckBox fechaVerTurnosAdminCheckBox;

    @FXML
    private Button guardarEdicionEditarUsuarioAdminButton;

    @FXML
    private Button guardarEdicionMiPerfilAdminButton;

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
    private TextField matriculaEdicionEditarUsuarioAdminField;

    @FXML
    private Label matriculaMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label matriculaMostrarEliminarUsuarioAdminLabel;

    @FXML
    private TextField matriculaNuevoUsuarioField;

    @FXML
    private CheckBox medicoVerTurnosAdminCheckBox;

    @FXML
    private AnchorPane menuAdminAnchorPane;

    @FXML
    private AnchorPane miPerfilAdminAnchorPane;

    @FXML
    private AnchorPane minimizeAdminButton;

    @FXML
    private Label miperfilAdminButton;

    @FXML
    private ImageView mostrarConfirmNewPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView mostrarConfirmNewPasswordEdicionMiPerfilAdminButton;

    @FXML
    private AnchorPane mostrarEditarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane mostrarEliminarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane mostrarMiPerfilAdminAnchorPane;

    @FXML
    private ImageView mostrarNewPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView mostrarNewPasswordEdicionMiPerfilAdminButton;

    @FXML
    private ImageView mostrarPasswordNuevoUsuarioButton;

    @FXML
    private AnchorPane mostrarVerTurnosAdminAnchorPane;

    @FXML
    private PasswordField newPasswordEdicionEditarUsuarioAdminField;

    @FXML
    private PasswordField newPasswordEdicionMiPerfilAdminField;

    @FXML
    private TextField nombreEdicionEditarUsuarioAdminField;

    @FXML
    private TextField nombreEdicionMiPerfilAdminField;

    @FXML
    private Label nombreMiPerfilAdminLabel;

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
    private ImageView ocultarConfirmNewPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView ocultarConfirmNewPasswordEdicionMiPerfilAdminButton;

    @FXML
    private ImageView ocultarNewPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView ocultarNewPasswordEdicionMiPerfilAdminButton;

    @FXML
    private ImageView ocultarPasswordNuevoUsuarioButton;

    @FXML
    private CheckBox pacienteVerTurnosAdminCheckBox;

    @FXML
    private AnchorPane panelAdminAnchorPane;

    @FXML
    private PasswordField passwordNuevoUsuarioField;

    @FXML
    private TableColumn<?, ?> tablaMedicoColumnaHora;

    @FXML
    private TableColumn<?, ?> tablaMedicoColumnaPaciente;

    @FXML
    private TableColumn<?, ?> tablaTurnoMedicoColumnaFecha;

    @FXML
    private TableView<?> tablaTurnosMedico;

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
    private Label usuarioMiPerfilAdminLabel;

    @FXML
    private Label usuarioMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label usuarioMostrarEliminarUsuarioAdminLabel;

    @FXML
    private Label verTurnosAdminButton;

    @FXML
    private AnchorPane vistaAdminAnchorPane;


    @FXML
    public void initialize() {
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();

        try{
            usuarioMiPerfilAdminLabel.setText(usuarioLogueado.getNombreUsuario());
            nombreMiPerfilAdminLabel.setText(usuarioLogueado.getNombre());
            apellidoMiPerfilAdminLabel.setText(usuarioLogueado.getApellido());
            emailMiPerfilAdminLabel.setText(usuarioLogueado.getMail());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ MENU OPCIONES ]
    //"Mi Perfil", "Ver Turnos", "Nuevo Usuario", "Editar Usuario", "Eliminar Usuario"
    @FXML
    public void ocultarTodosLosAnchorPane (){
        //MI PERFIL
        miPerfilAdminAnchorPane.setVisible(false);
        mostrarMiPerfilAdminAnchorPane.setVisible(false);
        editarMiPerfilAdminAnchorPane.setVisible(false);
        //VER TURNOS
        verTurnosAdminAnchorPane.setVisible(false);
        buscarVerTurnosAdminAnchorPane.setVisible(false);
        mostrarVerTurnosAdminAnchorPane.setVisible(false);
        //NUEVO USUARIO
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        //EDITAR USUARIO
        editarUsuarioAdminAnchorPane.setVisible(false);
        buscarEditarUsuarioAdminAnchorPane.setVisible(false);
        mostrarEditarUsuarioAdminAnchorPane.setVisible(false);
        edicionEditarUsuarioAdminAnchorPane.setVisible(false);
        //ELIMINAR USUARIO
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(false);
        mostrarEliminarUsuarioAdminAnchorPane.setVisible(false);
    }


    @FXML
    void buttonMyProfileAdmin(MouseEvent event) { //Opción "Mi Perfil" de Menú-Admin
        ocultarTodosLosAnchorPane();

        miPerfilAdminAnchorPane.setVisible(true);
        mostrarMiPerfilAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonViewAppointmentAdmin(MouseEvent event) { //Opción "Ver Turnos" de Menú-Admin

    }

    @FXML
    void buttonNewUserAdmin(MouseEvent event) { //Opción "Nuevo Usuario" de Menú-Admin

    }

    @FXML
    void buttonEditUserAdmin(MouseEvent event) { //Opción "Editar Usuario" de Menú-Admin

    }

    @FXML
    void buttonDeleteUserAdmin(MouseEvent event) { //Opción "Eliminar Usuario" de Menú-Admin

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ BARRA TITULO ]
    //BOTONES: "Minimizar", "Cerrar".
    @FXML
    void clickClose(KeyEvent event) { //Botón Cerrar View-Admin

    }

    @FXML
    void clickMinimize(KeyEvent event) { //Botón Minimizar View-Admin

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - MI PERFIL ]

    //[ MOSTRAR PERFIL ]
    @FXML
    void clickEditeMyProfileAdmin(ActionEvent event) { //Botón Editar Mi Perfil

    }

    //[ EDITAR PERFIL ]
    @FXML
    void fieldNameEditMyProfileAdmin(ActionEvent event) { //Field Nombre en Editar Mi Perfil

    }

    @FXML
    void fieldSurnameEditMyProfileAdmin(ActionEvent event) { //Field Apellido en Editar Mi Perfil

    }

    @FXML
    void fieldEmailEditMyProfileAdmin(ActionEvent event) { //Field Email en Editar Mi Perfil

    }

    @FXML
    void fieldOldPasswoordEditMyProfileAdmin(ActionEvent event) { //Field Contraseña Actual en Editar Mi Perfil

    }

    @FXML
    void fieldNewPasswordEditMyProfileAdmin(ActionEvent event) { //Field Nueva Contraseña en Editar Mi Perfil

    }

    @FXML
    void clickHideNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Ocultar "Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void clickShowNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Mostrar "Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void fieldConfirmNewPasswordEditMyProfileAdmin(ActionEvent event) { //Field Confirmar Nueva Contraseña en Editar Mi Perfil

    }

    @FXML
    void clickHideConfirmNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Ocultar "Confirmar Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void clickShowConfirmNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Mostrar "Confirmar Nueva Contraseña" en Editar Mi Perfil

    }
    @FXML
    void clickSaveEditMyProfileAdmin(ActionEvent event) { //Botón guardar cambios en Editar Mi Perfil

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - VER TURNOS ]

    //[ BUSCAR TURNOS ]
    @FXML
    void checkDoctorSearchAppointment(ActionEvent event) { //CheckBox buscar por Doctor en Ver Turnos

    }

    @FXML
    void checkPatientSearchAppointment(ActionEvent event) { //CheckBox buscar por Paciente en Ver Turnos

    }

    @FXML
    void checkIsDateSearchAppointment(ActionEvent event) { //CheckBox buscar por Fecha en Ver Turnos

    }
    @FXML
    void fieldSearchAppointmentAdmin (ActionEvent event) { //Field buscar en Ver Turnos

    }
    @FXML
    void clickSearchAppointment (ActionEvent event){ //Botón buscar Turnos en Ver Turnos

    }

    //[ VER TURNOS ] PENDIENTE




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - NUEVO USUARIO ]
    @FXML
    void fieldUserNewUser(ActionEvent event) { //Field Usuario en Nuevo Usuario

    }

    @FXML
    void fieldPasswordNewUser(ActionEvent event) { //Field Contraseña en Nuevo Usuario

    }

    @FXML
    void clickHidePasswordNewUser(KeyEvent event) { //Botón ojo Ocultar "Contraseña" en Nuevo Usuario

    }

    @FXML
    void clickShowPasswordNewUser(KeyEvent event) { //Botón ojo Mostrar "Contraseña" en Nuevo Usuario

    }

    @FXML
    void fieldNameNewUser(ActionEvent event) { //Field Nombre en Nuevo Usuario

    }

    @FXML
    void fieldLastnameNewUser(ActionEvent event) { //Field Apellido en Nuevo Usuario

    }

    @FXML
    void fieldEmailNewUser(ActionEvent event) { //Field Email en Nuevo Usuario

    }

    @FXML
    void checkNewDoctor(ActionEvent event) { //CheckBox isMedico en Nuevo Usuario

    }

    @FXML
    void checkNewAdmin(ActionEvent event) { //CheckBox isAdmin en Nuevo Usuario

    }

    @FXML
    void choiceSpecialityNewUser(KeyEvent event) { //ChoiceBox Especialidad en Nuevo Usuario

    }

    @FXML
    void fieldLicenseNewUser(ActionEvent event) { //Field Matrícula en Nuevo Usuario


    }

    @FXML
    void clickSaveNewUser(ActionEvent event) { //Boton Guardar Nuevo Usuario

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - EDITAR USUARIO ]

    //[ BUSCAR USUARIO ]
    @FXML
    void checkIsDoctorSearchEdit(ActionEvent event) { //CheckBox buscarDoctor en Buscar de Editar Usuario

    }

    @FXML
    void checkIsAdminSearchEdit(ActionEvent event) { //CheckBox isAdmin en Buscar de Editar Usuario

    }

    @FXML
    void fieldUserSearchEdit(ActionEvent event) { //Field Usuario en Buscar de Editar Usuario

    }

    @FXML
    void clickSearchEdit(ActionEvent event) { //Botón Buscar en Buscar de Editar Usuario

    }

    //[ MOSTRAR USUARIO BUSCADO ]
    @FXML
    void clickCancelUserEdit(ActionEvent event) { //Botón Cancelar en Mostrar de Editar Usuario

    }

    @FXML
    void clickConfirmUserEdit(ActionEvent event) { //Botón Confirmar en Mostrar de Editar Usuario

    }

    @FXML
    void clickCloseShowUserEdit(KeyEvent event) {//Botón Cerrar en Mostrar de Editar Usuario

    }


    //[ EDITAR USUARIO ]

    @FXML
    void fieldNameUserEdit(ActionEvent event) { //Field Nombre en Editar Usuario

    }

    @FXML
    void fieldLastnameUserEdit(ActionEvent event) { //Field Apellido en Editar Usuario

    }

    @FXML
    void fieldEmailUserEdit(ActionEvent event) { //Field Email en Editar Usuario

    }

    @FXML
    void choiceSpecialityUserEdit(KeyEvent event) { //ChoiceBox Especialidad en Editar Usuario

    }

    @FXML
    void fieldLicenseUserEdit(ActionEvent event) { //Field Matricula en Editar Usuario

    }

    @FXML
    void fieldOldPasswoordUserEdit(ActionEvent event) {

    }

    @FXML
    void fieldNewPasswordUserEdit(ActionEvent event) { //Field Nueva Contraseña en Editar Usuario

    }

    @FXML
    void clickHideNewPasswordUserEdit(KeyEvent event) { //Botón ojo Ocultar "Nueva Contraseña" en Editar Usuario

    }

    @FXML
    void clickShowNewPasswordUserEdit(KeyEvent event) { //Botón ojo Mostrar "Nueva Contraseña" en Editar Usuario

    }

    @FXML
    void fieldConfirmNewPasswordUserEdit(ActionEvent event) { //Field Confirmar Nueva Contraseña en Editar Usuario

    }

    @FXML
    void clickHideConfirmNewPasswordUserEdit(KeyEvent event) { //Botón ojo Ocultar "Confirmar Nueva Contraseña" en Editar Usuario

    }

    @FXML
    void clickShowConfirmNewPasswordUserEdit(KeyEvent event) { //Botón ojo Mostrar "Confirmar Nueva Contraseña" en Editar Usuario

    }

    @FXML
    void clickSaveUserEdit(ActionEvent event) { //Botón Guardar Cambios en Editar Usuario

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - ELIMINAR USUARIO ]

    //[ BUSCAR USUARIO ]
    @FXML
    void checkIsDoctorSearchDelete(ActionEvent event) { //CheckBox buscarDoctor en Eliminar Usuario

    }

    @FXML
    void checkIsAdminSearchDelete(ActionEvent event) { //CheckBox isAdmin en Eliminar Usuario

    }

    @FXML
    void fieldUserSearchDelete(ActionEvent event) {

    }

    @FXML
    void clickSearchUserDelete(ActionEvent event) {

    }


    //[ MOSTRAR USUARIO BUSCADO ]
    @FXML
    void clickCancelUserDelete(ActionEvent event) { //Botón Cancelar en Eliminar Usuario

    }

    @FXML
    void clickConfirmUserDelete(ActionEvent event) { //Botón Confirmar en Eliminar Usuario

    }

    @FXML
    void clickCloseSearchDelete (KeyEvent event) { //Botón Cerrar Ventana en Eliminar Usuario

    }


}
