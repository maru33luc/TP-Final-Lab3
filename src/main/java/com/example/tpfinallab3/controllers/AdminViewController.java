package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

import static com.example.tpfinallab3.controllers.LoginController.showErrorAlert;

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
    private ChoiceBox<String> especialidadEdicionEditarUsuarioAdminChoiceBox;

    @FXML
    private Label especialidadMostrarEditarUsuarioAdminLabel;

    @FXML
    private Label especialidadMostrarEliminarUsuarioAdminLabel;

    @FXML
    private Label especialidadLabel;

    @FXML
    private ChoiceBox<Especialidad> especialidadNuevoUsuarioChoiceBox;

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
    private TextField plainPasswordNuevoUsuarioField;

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

    //Variables extras.
    private Especialidad seleccionEspecialidad; //para guardar la seleccion del choice box especialidades
    private Optional<Medico> medic; //para guardar el medico que se esta editando
    private Optional<Administrativo> admin; //para guardar el administrativo que se esta editando


    @FXML
    public void initialize() {
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        especialidadEdicionEditarUsuarioAdminChoiceBox.getItems().addAll(Especialidad.values().toString());
        especialidadNuevoUsuarioChoiceBox.getItems().addAll(Especialidad.values());

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
        ocultarTodosLosAnchorPane();

        verTurnosAdminAnchorPane.setVisible(true);
        buscarVerTurnosAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonNewUserAdmin(MouseEvent event) { //Opción "Nuevo Usuario" de Menú-Admin
        ocultarTodosLosAnchorPane();

        nuevoUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonEditUserAdmin(MouseEvent event) { //Opción "Editar Usuario" de Menú-Admin
        ocultarTodosLosAnchorPane();

        editarUsuarioAdminAnchorPane.setVisible(true);
        buscarEditarUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonDeleteUserAdmin(MouseEvent event) { //Opción "Eliminar Usuario" de Menú-Admin
        ocultarTodosLosAnchorPane();

        eliminarUsuarioAdminAnchorPane.setVisible(true);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ BARRA TITULO ]
    //BOTONES: "Minimizar", "Cerrar".
    @FXML
    void clickClose(KeyEvent event) { //Botón Cerrar View-Admin
        //para cerrar ventana.
    }

    @FXML
    void clickMinimize(KeyEvent event) { //Botón Minimizar View-Admin
        //para minimizar ventana.
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - MI PERFIL ]

    //[ MOSTRAR PERFIL ]
    @FXML
    void clickEditeMyProfileAdmin(ActionEvent event) { //Botón Editar Mi Perfil
        ocultarTodosLosAnchorPane();

        miPerfilAdminAnchorPane.setVisible(true);
        editarMiPerfilAdminAnchorPane.setVisible(true);




    }

    //[ EDITAR PERFIL ]
    @FXML
    void fieldNameEditMyProfileAdmin(ActionEvent event) { //Field Nombre en Editar Mi Perfil
        nombreEdicionMiPerfilAdminField.setPromptText(nombreMiPerfilAdminLabel.getText());
    }

    @FXML
    void fieldSurnameEditMyProfileAdmin(ActionEvent event) { //Field Apellido en Editar Mi Perfil
        apellidoEdicionMiPerfilAdminField.setPromptText(apellidoMiPerfilAdminLabel.getText());
    }

    @FXML
    void fieldEmailEditMyProfileAdmin(ActionEvent event) { //Field Email en Editar Mi Perfil
        emailEdicionMiPerfilAdminField.setPromptText(emailMiPerfilAdminLabel.getText());
    }

    @FXML
    void fieldOldPasswoordEditMyProfileAdmin(ActionEvent event) { //Field Contraseña Actual en Editar Mi Perfil
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();

        //valido contraseña vieja con ingresada
      /*  if (!actualPasswordEdicionMiPerfilAdminField.getText().equals(usuarioLogueado.getContrasena())) //AVERIGUAR ERROR
            showErrorAlert("¡Contraseña incorrecta!");*/
    }

    @FXML
    void fieldNewPasswordEditMyProfileAdmin(ActionEvent event) { //Field Nueva Contraseña en Editar Mi Perfil
        //valido que la nueva contraseña no sea igual a la vieja
        if (actualPasswordEdicionMiPerfilAdminField.getText().equals(newPasswordEdicionMiPerfilAdminField.getText())) {
            showErrorAlert("La nueva contraseña no puede ser igual a la anterior.");
        }//FALTA validar seguridad de la clave
    }

    @FXML
    void clickHideNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Ocultar "Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void clickShowNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Mostrar "Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void fieldConfirmNewPasswordEditMyProfileAdmin(ActionEvent event) { //Field Confirmar Nueva Contraseña en Editar Mi Perfil
        //valido que la nueva contraseña coincida con la confirmación
        if (!newPasswordEdicionMiPerfilAdminField.getText().equals(confirmNewPasswordEdicionMiPerfilAdminField.getText())) {
            showErrorAlert("La contraseña no coincide.");
        }
    }

    @FXML
    void clickHideConfirmNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Ocultar "Confirmar Nueva Contraseña" en Editar Mi Perfil

    }

    @FXML
    void clickShowConfirmNewPasswordEditMyProfileAdmin(KeyEvent event) { //Botón ojo Mostrar "Confirmar Nueva Contraseña" en Editar Mi Perfil

    }
    @FXML
    void clickSaveEditMyProfileAdmin(ActionEvent event) { //Botón guardar cambios en Editar Mi Perfil
        String nombre = nombreMiPerfilAdminLabel.getText();
        String apellido = apellidoMiPerfilAdminLabel.getText();
        String email = emailMiPerfilAdminLabel.getText();
        String password = confirmNewPasswordEdicionMiPerfilAdminField.getText();

        //setear el usuario con los datos ingresados
        SessionManager.getInstance().getEntidadLogueada().setNombre(nombre);
        SessionManager.getInstance().getEntidadLogueada().setApellido(apellido);
        SessionManager.getInstance().getEntidadLogueada().setMail(email);
     //   SessionManager.getInstance().getEntidadLogueada().setContrasena(password); //AVERIGUAR ERROR
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - VER TURNOS ]

    //[ BUSCAR TURNOS ] //PENDIENTE HASTA TENER LAS VISTAS DE MOSTRAR TURNOS
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

    //[ MOSTRAR TURNOS ] PENDIENTE




//NUEVO USUARIO////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void mostrarPassword(MouseEvent event) {
        passwordNuevoUsuarioField.setVisible(false);
        plainPasswordNuevoUsuarioField.setText(passwordNuevoUsuarioField.getText());
        plainPasswordNuevoUsuarioField.setVisible(true);
        mostrarPasswordNuevoUsuarioButton.setVisible(true);
        ocultarPasswordNuevoUsuarioButton.setVisible(false);
    }

    @FXML
    private void ocultarPassword(MouseEvent event) {
        plainPasswordNuevoUsuarioField.setVisible(false);
        passwordNuevoUsuarioField.setText(plainPasswordNuevoUsuarioField.getText());
        passwordNuevoUsuarioField.setVisible(true);
        mostrarPasswordNuevoUsuarioButton.setVisible(false);
        ocultarPasswordNuevoUsuarioButton.setVisible(true);
    }

    @FXML
    void checkNewDoctor(ActionEvent event) { //CheckBox isMedico en Nuevo Usuario
        if (isMedicoNuevoUsuarioCheckBox.isSelected()) {
            isAdminNuevoUsuarioCheckBox.setSelected(false);
            especialidadLabel.setVisible(true);
            especialidadNuevoUsuarioChoiceBox.setVisible(true);
        }
        if (!isMedicoNuevoUsuarioCheckBox.isSelected()) {
            especialidadLabel.setVisible(false);
            especialidadNuevoUsuarioChoiceBox.setVisible(false);
        }
    }

    @FXML
    void checkNewAdmin(ActionEvent event) { //CheckBox isAdmin en Nuevo Usuario
        if (isAdminNuevoUsuarioCheckBox.isSelected()) {
            isMedicoNuevoUsuarioCheckBox.setSelected(false);
            especialidadLabel.setVisible(false);
            especialidadNuevoUsuarioChoiceBox.setVisible(false);
        }
    }

    @FXML
    void clickSaveNewUser(ActionEvent event) { //Botón para crear nuevo usuario
        //si no se seleccionó tipo de usuario
        if (!isMedicoNuevoUsuarioCheckBox.isSelected() && !isAdminNuevoUsuarioCheckBox.isSelected()) {
            showErrorAlert("Debe seleccionar el tipo de usuario que quiere crear");
        }
        else {
            //si se seleccionó médico
            if (isMedicoNuevoUsuarioCheckBox.isSelected()) {
                //se instancia un objeto Médico con los datos ingresados
                Medico medico = new Medico(userNuevoUsuarioField.getText().toLowerCase(),
                        passwordNuevoUsuarioField.getText(),
                        nombreNuevoUsuarioField.getText(),
                        apellidoNuevoUsuarioField.getText(),
                        emailNuevoUsuarioField.getText(),
                        especialidadNuevoUsuarioChoiceBox.getValue());
                //se valida el ingreso de datos y se agrega a la lista de médicos
                try {
                    ValidationService.getInstance().validarDatosNuevoUsuario(medico);
                    MedicoService.getInstance().agregarMedico(medico);
                    LoginController.showSuccessAlert("Nuevo medico creado exitosamente");
                    ocultarTodosLosAnchorPane();
                } catch (Exception e) {
                    showErrorAlert(e.getMessage());
                }
            }
            //si se seleccionó administrativo
            else {
                //se instancia un objeto Administrativo con los datos ingresados
                Administrativo administrativo = new Administrativo(
                        userNuevoUsuarioField.getText().toLowerCase(),
                        passwordNuevoUsuarioField.getText(),
                        nombreNuevoUsuarioField.getText(),
                        apellidoNuevoUsuarioField.getText(),
                        emailNuevoUsuarioField.getText());
                //se valida el ingreso de datos y se agrega a la lista de administrativos
                try {
                    ValidationService.getInstance().validarDatosNuevoUsuario(administrativo);
                    AdministrativoService.getInstance().agregarAdministrativo(administrativo);
                    LoginController.showSuccessAlert("Nuevo administrativo creado exitosamente");
                    ocultarTodosLosAnchorPane();
                } catch (Exception e) {
                    showErrorAlert(e.getMessage());
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - EDITAR USUARIO ]

    //[ BUSCAR USUARIO ]
    @FXML
    void checkIsDoctorSearchEdit(ActionEvent event) { //CheckBox buscarMedico en Buscar de Editar Usuario
    }

    @FXML
    void checkIsAdminSearchEdit(ActionEvent event) { //CheckBox isAdmin en Buscar de Editar Usuario
    }

    @FXML
    void fieldUserSearchEdit(ActionEvent event) { //Field Usuario en Buscar de Editar Usuario
    }

    @FXML
    void clickSearchEdit(ActionEvent event) { //Botón Buscar en Buscar de Editar Usuario
        //busco el usuario a editar
        if (isMedicoBuscarEditarUsuarioCheckBox.isSelected())
            medic = MedicoService.getInstance().buscarMedicoPorNombreUsuario(userBuscarEditarUsuarioField.getText());
        else if (isAdminBuscarEditarUsuarioCheckBox.isSelected())
            admin = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(userBuscarEditarUsuarioField.getText());
        else
            showErrorAlert("Debe seleccionar un tipo de usuario.");

        //valido que el medico o admin existan.
        if (medic.isPresent() || admin.isPresent()) {
            //si existe, muestro anchorPane
            ocultarTodosLosAnchorPane();

            editarUsuarioAdminAnchorPane.setVisible(true);
            mostrarEditarUsuarioAdminAnchorPane.setVisible(true);
            //agrego los datos del usuario a los labels
            if (medic.isPresent()) {
                mostrarMedicoEnEditarUsuario (medic);
            }else if (admin.isPresent()) {
                mostrarAdminEnEditarUsuario(admin);
            }

        }else{
            //si no existe, muestro un error
            showErrorAlert("El usuario no existe.");
        }
    }

    private void mostrarMedicoEnEditarUsuario (Optional<Medico> medic){
        tipoUsuarioMostrarEditarUsuarioAdminField.setText("Médico");
        usuarioMostrarEditarUsuarioAdminLabel.setText(medic.get().getNombreUsuario());
        nombreMostrarEditarUsuarioAdminLabel.setText(medic.get().getNombre());
        apellidoMostrarEditarUsuarioAdminLabel.setText(medic.get().getApellido());
        emailMostrarEditarUsuarioAdminLabel.setText(medic.get().getMail());
        especialidadMostrarEditarUsuarioAdminLabel.setText(medic.get().getEspecialidad().getEspecialidad());
    }

    private void mostrarAdminEnEditarUsuario (Optional<Administrativo> admin){
        tipoUsuarioMostrarEditarUsuarioAdminField.setText("Administrativo");
        usuarioMostrarEditarUsuarioAdminLabel.setText(admin.get().getNombreUsuario());
        nombreMostrarEditarUsuarioAdminLabel.setText(admin.get().getNombre());
        apellidoMostrarEditarUsuarioAdminLabel.setText(admin.get().getApellido());
        emailMostrarEditarUsuarioAdminLabel.setText(admin.get().getMail());
    }




    //[ MOSTRAR USUARIO BUSCADO ]
    @FXML
    void clickCancelUserEdit(ActionEvent event) { //Botón Cancelar en Mostrar de Editar Usuario
        ocultarTodosLosAnchorPane();

        editarUsuarioAdminAnchorPane.setVisible(true);
        buscarEditarUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void clickConfirmUserEdit(ActionEvent event) { //Botón Confirmar en Mostrar de Editar Usuario
        ocultarTodosLosAnchorPane();

        editarUsuarioAdminAnchorPane.setVisible(true);
        edicionEditarUsuarioAdminAnchorPane.setVisible(true);
        agregarDatosAFieldEditarUsuario();
    }

    private void agregarDatosAFieldEditarUsuario(){
        nombreEdicionEditarUsuarioAdminField.setPromptText(nombreMostrarEditarUsuarioAdminLabel.getText());
        apellidoEdicionEditarUsuarioAdminField.setPromptText(apellidoMostrarEditarUsuarioAdminLabel.getText());
        emailEdicionEditarUsuarioAdminField.setPromptText(emailMostrarEditarUsuarioAdminLabel.getText());

        if (tipoUsuarioMostrarEditarUsuarioAdminField.getText().equals("Médico")) {
            especialidadEdicionEditarUsuarioAdminChoiceBox.setOnAction(event1-> {
                seleccionEspecialidad = Especialidad.valueOf(especialidadEdicionEditarUsuarioAdminChoiceBox.getValue());}); //REVISAR: estas ultimas lineas no se si funcionarán
        }else{
            especialidadEdicionEditarUsuarioAdminChoiceBox.setVisible(false);
        }
    }

    @FXML
    void clickCloseShowUserEdit(KeyEvent event) {//Botón Cerrar en Mostrar de Editar Usuario
        ocultarTodosLosAnchorPane();

        editarUsuarioAdminAnchorPane.setVisible(true);
        buscarEditarUsuarioAdminAnchorPane.setVisible(true);
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

    /*@FXML
    void choiceSpecialityUserEdit(KeyEvent event) { //ChoiceBox Especialidad en Editar Usuario

    }


    //EN PROGRESO
    @FXML
    void fieldOldPasswoordUserEdit(ActionEvent event) {
        //valido que la password ingresada coincida con la del usuario
        /*if (medic.isPresent()) {
            if (medic.get().getPassword().equals(oldPasswordEdicionEditarUsuarioAdminField.getText())) {
                //si coincide, muestro el resto de los campos
                nombreEdicionEditarUsuarioAdminField.setVisible(true);
                apellidoEdicionEditarUsuarioAdminField.setVisible(true);
                emailEdicionEditarUsuarioAdminField.setVisible(true);
                especialidadEdicionEditarUsuarioAdminChoiceBox.setVisible(true);
                confirmarEdicionEditarUsuarioAdminButton.setVisible(true);
            }else{
                //si no coincide, muestro un error
                showErrorAlert("La contraseña ingresada no es correcta.");
            }
    }*/

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


    //ALERTAS
    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void choiceSpecialityNewUser(KeyEvent keyEvent) {
    }

    public void choiceSpecialityUserEdit(KeyEvent keyEvent) {
    }
}