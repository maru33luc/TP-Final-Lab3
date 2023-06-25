package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

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
    private AnchorPane bienvenidoAdminPanel;

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
    private AnchorPane buscarEditarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane mostrarEliminarUsuarioAdminAnchorPane;

    @FXML
    private AnchorPane filtroEliminarUsuarioAdminAnchorPane;

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
    private PasswordField confirmNewPasswordEdicionEditarUsuarioAdminField;

    @FXML
    private PasswordField confirmNewPasswordEdicionMiPerfilAdminField;

    @FXML
    private Button confirmarEliminarUsuarioAdminButton;

    @FXML
    private Button confirmarUsuarioEditarUsuarioButton;

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
    private AnchorPane mostrarEditarUsuarioAdminAnchorPane;


    @FXML
    private AnchorPane mostrarMiPerfilAdminAnchorPane;

    @FXML
    private ImageView mostrarNewPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView mostrarPasswordNuevoUsuarioButton;

    @FXML
    private AnchorPane mostrarVerTurnosAdminAnchorPane;

    @FXML
    private PasswordField newPasswordEdicionEditarUsuarioAdminField;

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
    private ImageView ocultarNewPasswordEdicionEditarUsuarioAdminButton;

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
        bienvenidoAdminPanel.setVisible(false);
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
        //ocultarTodosLosAnchorPane();
        bienvenidoAdminPanel.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(true);
        mostrarMiPerfilAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonViewAppointmentAdmin(MouseEvent event) { //Opción "Ver Turnos" de Menú-Admin
        //ocultarTodosLosAnchorPane();
        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);

        verTurnosAdminAnchorPane.setVisible(true);
        buscarVerTurnosAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonNewUserAdmin(MouseEvent event) { //Opción "Nuevo Usuario" de Menú-Admin
        //ocultarTodosLosAnchorPane();
        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);


        nuevoUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonEditUserAdmin(MouseEvent event) { //Opción "Editar Usuario" de Menú-Admin
        //ocultarTodosLosAnchorPane();

        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);

        editarUsuarioAdminAnchorPane.setVisible(true);
        buscarEditarUsuarioAdminAnchorPane.setVisible(true);
        isMedicoBuscarEditarUsuarioCheckBox.setSelected(false);
        isAdminBuscarEditarUsuarioCheckBox.setSelected(false);
    }

    @FXML
    void buttonDeleteUserAdmin(MouseEvent event) { //Opción "Eliminar Usuario" de Menú-Admin
        //ocultarTodosLosAnchorPane();

        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);

        eliminarUsuarioAdminAnchorPane.setVisible(true);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
        isMedicoBuscarEliminarUsuarioCheckBox.setSelected(false);
        isAdminBuscarEliminarUsuarioCheckBox.setSelected(false);
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

//MI PERFIL///////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR PERFIL//////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void clickEditeMyProfileAdmin(ActionEvent event) { //Botón Editar Mi Perfil
        ocultarTodosLosAnchorPane();
        miPerfilAdminAnchorPane.setVisible(true);
        editarMiPerfilAdminAnchorPane.setVisible(true);
        agregarDatosAFieldEditarMiPerfil();
    }

    private void agregarDatosAFieldEditarMiPerfil (){
        nombreEdicionMiPerfilAdminField.setPromptText(nombreMiPerfilAdminLabel.getText());
        apellidoEdicionMiPerfilAdminField.setPromptText(apellidoMiPerfilAdminLabel.getText());
        emailEdicionMiPerfilAdminField.setPromptText(emailMiPerfilAdminLabel.getText());
    }

    //EDITAR PERFIL///////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void guardarEditarPerfilAdmin(ActionEvent event) {
        //se guardan los datos ingresados
        String nombre = nombreEdicionMiPerfilAdminField.getText();
        String apellido = apellidoEdicionMiPerfilAdminField.getText();
        String mail = emailEdicionMiPerfilAdminField.getText();

        try {
            //se validan los datos ingresados
            ValidationService.getInstance().validarDatosEditarPerfilAdmin(nombre, apellido, mail);
            //se recupera el usuario logueado
            String usuario = SessionManager.getInstance().getEntidadLogueada().getNombreUsuario();
            //se modifica el usuario logueado en la lista de administrativos y el json
            AdministrativoService.getInstance().modificarAdministrativo(usuario, nombre, apellido, mail);
            //se setean los datos a mostrar en el perfil para esta sesión
            nombreMiPerfilAdminLabel.setText(nombre);
            apellidoMiPerfilAdminLabel.setText(apellido);
            emailMiPerfilAdminLabel.setText(mail);
            //se envía mensaje de éxito en la modificación
            LoginController.showSuccessAlert("Datos modificados exitosamente");
            ocultarTodosLosAnchorPane();
        } catch (Exception e) {
            showErrorAlert(e.getMessage());
        }

        //setear el usuario con los datos ingresados
        /*SessionManager.getInstance().getEntidadLogueada().setNombre(nombre);
        SessionManager.getInstance().getEntidadLogueada().setApellido(apellido);
        SessionManager.getInstance().getEntidadLogueada().setMail(mail);*/
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


    public void choiceSpecialityNewUser(KeyEvent keyEvent) {
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

//EDITAR USUARIO//////////////////////////////////////////////////////////////////////////////////////////////

    //BUSCAR USUARIO//////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void checkIsDoctorSearchEdit(ActionEvent event) { //CheckBox buscarMedico en Buscar de Editar Usuario
        //si se selecciona el checkbox de buscarMedico, se deselecciona el de buscarAdmin
        if (isAdminBuscarEditarUsuarioCheckBox.isSelected()) {
            isAdminBuscarEditarUsuarioCheckBox.setSelected(false);
        }
    }

    @FXML
    void checkIsAdminSearchEdit(ActionEvent event) { //CheckBox isAdmin en Buscar de Editar Usuario
        //validar que solo un checkbox esté accionado
        if (isMedicoBuscarEditarUsuarioCheckBox.isSelected()) {
            isMedicoBuscarEditarUsuarioCheckBox.setSelected(false);
        }
    }

    private boolean validarFieldUserSearchEdit() {
        if (userBuscarEditarUsuarioField.getText().isEmpty()) {
            showErrorAlert("Debe ingresar un nombre de usuario.");
            return false;
        }
        return true;
    }

    @FXML
    void clickSearchEdit(ActionEvent event) { //Botón Buscar en Buscar de Editar Usuario
        medic = null;
        admin = null;

        //validar que se haya ingresado un nombre de usuario
        if (validarFieldUserSearchEdit()){
            //validar que se haya seleccionado un tipo de usuario
            if (isMedicoBuscarEditarUsuarioCheckBox.isSelected()) {
                medic = MedicoService.getInstance().buscarMedicoPorNombreUsuario(userBuscarEditarUsuarioField.getText());
                if (!medic.isPresent()) //acá valido que el usuario exista y sea médico
                    showErrorAlert("El usuario no existe o no es médico.");
            }else if (isAdminBuscarEditarUsuarioCheckBox.isSelected()) {
                admin = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(userBuscarEditarUsuarioField.getText());
                if (!admin.isPresent())
                    showErrorAlert("El usuario no existe o no es administrativo.");
            }else {
                showErrorAlert("Debe seleccionar un tipo de usuario.");
            }
        }

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

    */
    public void choiceSpecialityUserEdit(KeyEvent keyEvent) {
    }


    //EN PROGRESO
    @FXML
    void fieldOldPasswoordUserEdit(ActionEvent event) { //Field Contraseña Actual en Editar Usuario
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

        if (medic.isPresent()) {
            if (!medic.get().getContrasena().equals(actualPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("Contraseña inválida.");
            else
                showSuccessAlert("Contraseña válida.");

        }else if (admin.isPresent()) {
            if (!admin.get().getContrasena().equals(actualPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("Contraseña inválida.");
            else
                showSuccessAlert("Contraseña válida.");
        }
    }


    @FXML
    void fieldNewPasswordUserEdit(ActionEvent event) { //Field Nueva Contraseña en Editar Usuario
        //valido que la nueva contraseña sea distinta a la vieja
        if (medic.isPresent()) {
            if (medic.get().getContrasena().equals(newPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("La nueva contraseña debe ser distinta a la anterior.");
            else
                showSuccessAlert("Contraseña válida.");
        }else if (admin.isPresent()) {
            if (admin.get().getContrasena().equals(newPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("La nueva contraseña debe ser distinta a la anterior.");
            else
                showSuccessAlert("Contraseña válida.");
        }

    }

    @FXML
    void clickHideNewPasswordUserEdit(KeyEvent event) { //Botón ojo Ocultar "Nueva Contraseña" en Editar Usuario
        //COMPLETAR
    }

    @FXML
    void clickShowNewPasswordUserEdit(KeyEvent event) { //Botón ojo Mostrar "Nueva Contraseña" en Editar Usuario
        //COMPLTAR
    }

    @FXML
    void fieldConfirmNewPasswordUserEdit(ActionEvent event) { //Field Confirmar Nueva Contraseña en Editar Usuario
        //Valido que la confirmacion sea la misma contraseña que la nueva.
        if (medic.isPresent()) {
            if (!medic.get().getContrasena().equals(confirmNewPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("Las contraseñas no coinciden.");
            else
                showSuccessAlert("Contraseña válida.");
        }else if (admin.isPresent()){
            if (!admin.get().getContrasena().equals(confirmNewPasswordEdicionEditarUsuarioAdminField.getText()))
                showErrorAlert("Las contraseñas no coinciden.");
            else
                showSuccessAlert("Contraseña válida.");
        }
    }

    @FXML
    void clickHideConfirmNewPasswordUserEdit(KeyEvent event) { //Botón ojo Ocultar "Confirmar Nueva Contraseña" en Editar Usuario
        //COMPLETAR
    }

    @FXML
    void clickShowConfirmNewPasswordUserEdit(KeyEvent event) { //Botón ojo Mostrar "Confirmar Nueva Contraseña" en Editar Usuario
        //COMPLETAR
    }

    @FXML
    void clickSaveUserEdit(ActionEvent event) { //Botón Guardar Cambios en Editar Usuario
        String nombre = nombreEdicionEditarUsuarioAdminField.getText();
        String apellido = apellidoEdicionEditarUsuarioAdminField.getText();
        String email = emailEdicionEditarUsuarioAdminField.getText();
        String password = confirmNewPasswordEdicionEditarUsuarioAdminField.getText();

        //setear el usuario con los datos ingresados
        if (medic.isPresent()) {
            medic.get().setNombre(nombre);
            medic.get().setApellido(apellido);
            medic.get().setMail(email);
            medic.get().setContrasena(password);
        }else if (admin.isPresent()){
            admin.get().setNombre(nombre);
            admin.get().setApellido(apellido);
            admin.get().setMail(email);
            admin.get().setContrasena(password);
        }

        //mostrar mensaje de confirmación
        showSuccessAlert("¡Cambios guardados con éxito!");
    }

    /////////////////////////////// HABILITAR TURNOS ///////////////////////////////

    @FXML
    void buttonAddAppointmentAdmin(MouseEvent event) {

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

    private boolean validarFieldUserSearchDelete() {
        if (userBuscarEliminarUsuarioField.getText().isEmpty()) {
            showErrorAlert("Debe ingresar un nombre de usuario.");
            return false;
        }
        return true;
    }

    @FXML
    void clickSearchUserDelete(ActionEvent event) {
        medic = null;
        admin = null;

        //validar que se haya ingresado un nombre de usuario
        if (validarFieldUserSearchDelete()){
            //validar que se haya seleccionado un tipo de usuario
            if (isMedicoBuscarEliminarUsuarioCheckBox.isSelected()) {
                medic = MedicoService.getInstance().buscarMedicoPorNombreUsuario(userBuscarEliminarUsuarioField.getText());
                if (!medic.isPresent()) //acá valido que el usuario exista y sea médico
                    showErrorAlert("El usuario no existe o no es médico.");
            }else if (isAdminBuscarEliminarUsuarioCheckBox.isSelected()) {
                admin = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(userBuscarEliminarUsuarioField.getText());
                if (!admin.isPresent())
                    showErrorAlert("El usuario no existe o no es administrativo.");
            }else {
                showErrorAlert("Debe seleccionar un tipo de usuario.");
            }
        }

        //valido que el medico o admin existan.
        if (medic.isPresent() || admin.isPresent()) {
            //si existe, muestro anchorPane
            ocultarTodosLosAnchorPane();

            eliminarUsuarioAdminAnchorPane.setVisible(true);
            mostrarEliminarUsuarioAdminAnchorPane.setVisible(true);
            //agrego los datos del usuario a los labels
            if (medic.isPresent()) {
                mostrarMedicoEnEliminarUsuario (medic);
            }else if (admin.isPresent()) {
                mostrarAdminEnEliminarUsuario(admin);
            }
        }else{
            //si no existe, muestro un error
            showErrorAlert("El usuario no existe.");
        }
    }

    private void mostrarMedicoEnEliminarUsuario (Optional<Medico> medico){
        tipoUsuarioMostrarEliminarUsuarioAdminLabel.setText("Médico");
        nombreMostrarEliminarUsuarioAdminLabel.setText(medico.get().getNombre());
        apellidoMostrarEliminarUsuarioAdminLabel.setText(medico.get().getApellido());
        emailMostrarEliminarUsuarioAdminLabel.setText(medico.get().getMail());
        especialidadEdicionEditarUsuarioAdminChoiceBox.setOnAction(event1-> {
            seleccionEspecialidad = Especialidad.valueOf(especialidadEdicionEditarUsuarioAdminChoiceBox.getValue());}); //CORREGIR ESTO
    }

    private void mostrarAdminEnEliminarUsuario (Optional<Administrativo> admin){
        tipoUsuarioMostrarEliminarUsuarioAdminLabel.setText("Administrativo");
        nombreMostrarEliminarUsuarioAdminLabel.setText(admin.get().getNombre());
        apellidoMostrarEliminarUsuarioAdminLabel.setText(admin.get().getApellido());
        emailMostrarEliminarUsuarioAdminLabel.setText(admin.get().getMail());
        especialidadMostrarEliminarUsuarioAdminLabel.setVisible(false);
    }


    //[ MOSTRAR USUARIO BUSCADO ]
    @FXML
    void clickCancelUserDelete(ActionEvent event) { //Botón Cancelar en Eliminar Usuario
        ocultarTodosLosAnchorPane();

        eliminarUsuarioAdminAnchorPane.setVisible(true);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void clickConfirmUserDelete(ActionEvent event) { //Botón Confirmar en Eliminar Usuario
        //TERMINAR
        if (medic.isPresent()) {
            MedicoService.getInstance().eliminarMedico(medic.get());
        }else if (admin.isPresent()) {
            AdministrativoService.getInstance().eliminarAdministrativoPorNombreUsuario(admin.get().getNombreUsuario());
        }

    }

    @FXML
    void clickCloseSearchDelete (KeyEvent event) { //Botón Cerrar Ventana en Eliminar Usuario
        ocultarTodosLosAnchorPane();

        eliminarUsuarioAdminAnchorPane.setVisible(true);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
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

// ----------------------------     ACA METO FUNCIONES PARA DESTRABAR ERRORES -----------------------------
    public void buttonCloseSessionAdmin(MouseEvent mouseEvent) {
    }

    public void tableEditUserAction(MouseEvent mouseEvent) {
    }

    public void tableDeleteUserAction(MouseEvent mouseEvent) {
    }

    public void clickSearchAppointmentAdmin(ActionEvent actionEvent) {
    }
}