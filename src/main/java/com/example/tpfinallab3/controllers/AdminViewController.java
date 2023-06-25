package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;
import com.example.tpfinallab3.services.TurnoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.TimeoutException;

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
    private TableColumn<?, ?> columnaFechaTurnosMedico;

    @FXML
    private TableColumn<?, ?> columnaHoraTurnosMedico;

    @FXML
    private TableColumn<?, ?> columnaPacienteTurnosMedico;

    @FXML
    private TableColumn<?, ?> columnaObraSocialTurnosMedico;

    @FXML
    private TableColumn<?, ?> columnaFechaTurnosPaciente;

    @FXML
    private TableColumn<?, ?> columnaHoraTurnosPaciente;

    @FXML
    private TableColumn<?, ?> columnaMedicoTurnosPaciente;

    @FXML
    private TableColumn<?, ?> columnaEspecialidadTurnosPaciente;

    @FXML
    private TableColumn<?, ?> columnaHoraTurnosFecha;

    @FXML
    private TableColumn<?, ?> columnaPacienteTurnosFecha;

    @FXML
    private TableColumn<?, ?> columnaMedicoTurnosFecha;

    @FXML
    private TableColumn<?, ?> columnaEspecialidadTurnosFecha;

    @FXML
    private TableColumn<?, ?> columnaUserBuscarEditarUsuario;

    @FXML
    private TableColumn<?, ?> columnaNombreBuscarEditarUsuario;

    @FXML
    private TableColumn<?, ?> columnaApellidoBuscarEditarUsuario;

    @FXML
    private TableColumn<?, ?> columnaTipoUsuarioBuscarEditarUsuario;

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
    private Label fechaVerTurnosLabel;

    @FXML
    private AnchorPane filtrarVerTurnosAdminAnchorPane;

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
    private AnchorPane listaTurnosPacienteVerTurnosAdminAnchorPane;

    @FXML
    private AnchorPane listaTurnosMedicoVerTurnosAdminAnchorPane;

    @FXML
    private AnchorPane listaTurnosFechaVerTurnosAdminAnchorPane;

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
    private TableView<TurnoTabla> tablaTurnosMedicoAdmin;

    @FXML
    private TableView<TurnoTabla> tablaTurnosPacienteAdmin;

    @FXML
    private TableView<TurnoTabla> tablaTurnosFechaAdmin;

    @FXML
    private TableView<TablaUsuario> tablaBuscarEditarUsuarioAdminAnchorPane;

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
    private Label userPacienteVerTurnosLabel;

    @FXML
    private Label userMedicoVerTurnosLabel;

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
    ///////////////////////////////////////////////////

    @FXML
    private Label IngreseVerTurnosAdminLabel;

    @FXML
    private Label adminUserName;

    @FXML
    private Label agregarTurnoAdminButton;


    @FXML
    private Label cerrarSesionAdminButton;


    @FXML
    private TableColumn<?, ?> columnaApellidoBuscarEliminarUsuario;


    @FXML
    private TableColumn<?, ?> columnaNombreBuscarEliminarUsuario;


    @FXML
    private TableColumn<?, ?> columnaTipoUsuarioBuscarEliminarUsuario;

    @FXML
    private TableColumn<?, ?> columnaUsuarioBuscarEliminarUsuario;

    @FXML
    private AnchorPane filtrarEliminarUsuarioAdminAnchorPane;


    @FXML
    private TableView<TablaUsuario> tablaBuscarEliminarUsuarioAdminAnchorPane;


    //NUEVOS DE VISTA HABILITAR TURNOS:
    @FXML
    private AnchorPane habilitarTurnosAdminAnchorPane;

    @FXML
    private TextField nombreYApellidoMedicoHabilitarTurnosField;

    @FXML
    private TextField fechaHabilitarTurnosField;

    @FXML
    private TextField horaInicioHabilitarTurnosField;

    @FXML
    private TextField horaFinalizacionHabilitarTurnosField;

    @FXML
    private Button confirmarHabilitarTurnosButton;




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
        bienvenidoAdminPanel.setVisible(false);
        //VER TURNOS
        verTurnosAdminAnchorPane.setVisible(false);
        filtrarVerTurnosAdminAnchorPane.setVisible(false);
        mostrarVerTurnosAdminAnchorPane.setVisible(false);
        //HABILITAR TURNOS
        habilitarTurnosAdminAnchorPane.setVisible(false);
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
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

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
        filtrarVerTurnosAdminAnchorPane.setVisible(true);
        verTurnosAdminAnchorPane.setVisible(true);
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

        mostrarVerTurnosAdminAnchorPane.setVisible(false);
        medicoVerTurnosAdminCheckBox.setSelected(false);
        pacienteVerTurnosAdminCheckBox.setSelected(false);
        fechaVerTurnosAdminCheckBox.setSelected(false);
        BuscarVerTurnoAdminField.setText("");


        //buscarVerTurnosAdminAnchorPane.setVisible(true);

    }

    @FXML
    void buttonAddAppointmentAdmin (MouseEvent event){ //Opción "Habilitar Turno" de Menú-Admin
        //ocultar
        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);

        habilitarTurnosAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonNewUserAdmin(MouseEvent event) { //Opción "Nuevo Usuario" de Menú-Admin
        //ocultarTodosLosAnchorPane();
        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

        nuevoUsuarioAdminAnchorPane.setVisible(true);
    }

    @FXML
    void buttonEditUserAdmin(MouseEvent event) { //Opción "Editar Usuario" de Menú-Admin
        ocultarTodosLosAnchorPane();

        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

        editarUsuarioAdminAnchorPane.setVisible(true);
        buscarEditarUsuarioAdminAnchorPane.setVisible(true);
        isMedicoBuscarEditarUsuarioCheckBox.setSelected(false);
        isAdminBuscarEditarUsuarioCheckBox.setSelected(false);
        mostrarEditarUsuarioAdminAnchorPane.setVisible(false);

        cargarUsuariosEnTablaEditar();

    }

    @FXML
    void tableEditUserAction(MouseEvent event) {
        if(tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem() != null){
            mostrarEditarUsuarioAdminAnchorPane.setVisible(true);
            buscarEditarUsuarioAdminAnchorPane.setVisible(false);
            tipoUsuarioMostrarEditarUsuarioAdminField.setText(tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getEntidad());
            usuarioMostrarEditarUsuarioAdminLabel.setText(tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getUsuario());
            nombreMostrarEditarUsuarioAdminLabel.setText(tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getNombre());
            apellidoMostrarEditarUsuarioAdminLabel.setText(tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getApellido());
            String nombreUsuario= tablaBuscarEditarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getUsuario();
            // recuperar el mail del usuario seleccionado

            Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
            Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);
            Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(nombreUsuario);
            if(medico.isPresent()){
                emailMostrarEditarUsuarioAdminLabel.setText(medico.get().getMail());
                especialidadMostrarEditarUsuarioAdminLabel.setText(medico.get().getEspecialidad().toString());
            }else if(administrativo.isPresent()){
                emailMostrarEditarUsuarioAdminLabel.setText(administrativo.get().getMail());
            }else if(paciente.isPresent()){
                emailMostrarEditarUsuarioAdminLabel.setText(paciente.get().getMail());
            }

        }
    }


    public void cargarUsuariosEnTablaEditar() {
        Map <String, Usuario> listaAutenticables = new HashMap<>();

        Set<Medico> listaMedicos = MedicoService.getInstance().getMedicosActivos();
        Set<Administrativo> listaAdministrativos = AdministrativoService.getInstance().getAdministrativos();
        Set<Paciente> listaPacientes = PacienteService.getInstance().getPacientes();

        for (Medico medico : listaMedicos) {
            listaAutenticables.put(medico.getNombreUsuario(), medico);
        }
        for (Administrativo administrativo : listaAdministrativos) {
            listaAutenticables.put(administrativo.getNombreUsuario(), administrativo);
        }
        /*for (Paciente paciente : listaPacientes) {
            listaAutenticables.put(paciente.getNombreUsuario(), paciente);
        }*/

        List<TablaUsuario> turnosTablaUsuario = new ArrayList<>();
        //recorrer el map y pasar los datos a un objeto de tipo TurnoTablaUsuario
        //para luego agregarlo a la lista de turnosTablaUsuario
        for (Map.Entry<String, Usuario> entry : listaAutenticables.entrySet()) {
            String key = entry.getKey();
            Usuario value = entry.getValue();
            if (value instanceof Medico) {
                Medico medico = (Medico) value;
                turnosTablaUsuario.add(new TablaUsuario(medico.getNombreUsuario(), medico.getNombre(), medico.getApellido(), "Medico"));
            }
            if (value instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) value;
                turnosTablaUsuario.add(new TablaUsuario(administrativo.getNombreUsuario(), administrativo.getNombre(), administrativo.getApellido(), "Administrativo"));
            }
            if (value instanceof Paciente) {
                Paciente paciente = (Paciente) value;
                turnosTablaUsuario.add(new TablaUsuario(paciente.getNombreUsuario(), paciente.getNombre(), paciente.getApellido(),  "Paciente"));
            }
        }
        columnaUserBuscarEditarUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        columnaNombreBuscarEditarUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidoBuscarEditarUsuario.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaTipoUsuarioBuscarEditarUsuario.setCellValueFactory(new PropertyValueFactory<>("entidad"));

        //cargar la lista de turnosTablaUsuario en la tabla
        tablaBuscarEditarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(turnosTablaUsuario));

    }


    @FXML
    void buttonDeleteUserAdmin(MouseEvent event) { //Opción "Eliminar Usuario" de Menú-Admin
        //ocultarTodosLosAnchorPane();

        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

        eliminarUsuarioAdminAnchorPane.setVisible(true);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
        isMedicoBuscarEliminarUsuarioCheckBox.setSelected(false);
        isAdminBuscarEliminarUsuarioCheckBox.setSelected(false);
        cargarUsuariosEnTablaEliminar();
    }

    public void cargarUsuariosEnTablaEliminar() {
        Map <String, Usuario> listaAutenticables = new HashMap<>();

        Set<Medico> listaMedicos = MedicoService.getInstance().getMedicosActivos();
        Set<Administrativo> listaAdministrativos = AdministrativoService.getInstance().getAdministrativos();
        Set<Paciente> listaPacientes = PacienteService.getInstance().getPacientes();

        for (Medico medico : listaMedicos) {
            listaAutenticables.put(medico.getNombreUsuario(), medico);
        }
        for (Administrativo administrativo : listaAdministrativos) {
            listaAutenticables.put(administrativo.getNombreUsuario(), administrativo);
        }
        /*for (Paciente paciente : listaPacientes) {
            listaAutenticables.put(paciente.getNombreUsuario(), paciente);
        }*/

        List<TablaUsuario> turnosTablaUsuario = new ArrayList<>();
        //recorrer el map y pasar los datos a un objeto de tipo TurnoTablaUsuario
        //para luego agregarlo a la lista de turnosTablaUsuario
        for (Map.Entry<String, Usuario> entry : listaAutenticables.entrySet()) {
            String key = entry.getKey();
            Usuario value = entry.getValue();
            if (value instanceof Medico) {
                Medico medico = (Medico) value;
                turnosTablaUsuario.add(new TablaUsuario(medico.getNombreUsuario(), medico.getNombre(), medico.getApellido(), "Medico"));
            }
            if (value instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) value;
                turnosTablaUsuario.add(new TablaUsuario(administrativo.getNombreUsuario(), administrativo.getNombre(), administrativo.getApellido(), "Administrativo"));
            }
            if (value instanceof Paciente) {
                Paciente paciente = (Paciente) value;
                turnosTablaUsuario.add(new TablaUsuario(paciente.getNombreUsuario(), paciente.getNombre(), paciente.getApellido(),  "Paciente"));
            }
        }
        columnaUsuarioBuscarEliminarUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        columnaNombreBuscarEliminarUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidoBuscarEliminarUsuario.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaTipoUsuarioBuscarEliminarUsuario.setCellValueFactory(new PropertyValueFactory<>("entidad"));

        //cargar la lista de turnosTablaUsuario en la tabla
        tablaBuscarEliminarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(turnosTablaUsuario));

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
        //ocultarTodosLosAnchorPane();
        bienvenidoAdminPanel.setVisible(false); //agregado yasz.
        verTurnosAdminAnchorPane.setVisible(false); //agregado yasz.
        nuevoUsuarioAdminAnchorPane.setVisible(false); //agregado yasz.
        editarUsuarioAdminAnchorPane.setVisible(false); //agregado yasz.
        eliminarUsuarioAdminAnchorPane.setVisible(false); //agregado yasz.
        habilitarTurnosAdminAnchorPane.setVisible(false);//agregado yasz.

        miPerfilAdminAnchorPane.setVisible(true);
        mostrarMiPerfilAdminAnchorPane.setVisible(false);
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
            LoginController.showErrorAlert(e.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //----------------------------[ VIEW - VER TURNOS ]

    //[ BUSCAR TURNOS ]
    @FXML
    void checkDoctorSearchAppointment(ActionEvent event) { //CheckBox buscar por Doctor en Ver Turnos
        if (medicoVerTurnosAdminCheckBox.isSelected()) { //nuevo yasz
            pacienteVerTurnosAdminCheckBox.setSelected(false);
            fechaVerTurnosAdminCheckBox.setSelected(false);
            IngreseVerTurnosAdminLabel.setText("Ingrese el user del médico");
        }
    }

    @FXML
    void checkPatientSearchAppointment(ActionEvent event) { //CheckBox buscar por Paciente en Ver Turnos
        if (pacienteVerTurnosAdminCheckBox.isSelected()) { //nuevo yasz
            medicoVerTurnosAdminCheckBox.setSelected(false);
            fechaVerTurnosAdminCheckBox.setSelected(false);
            IngreseVerTurnosAdminLabel.setText("Ingrese el user del paciente");
        }
    }

    @FXML
    void checkIsDateSearchAppointment(ActionEvent event) { //CheckBox buscar por Fecha en Ver Turnos
        if (fechaVerTurnosAdminCheckBox.isSelected()) { //nuevo yasz
            medicoVerTurnosAdminCheckBox.setSelected(false);
            pacienteVerTurnosAdminCheckBox.setSelected(false);
            IngreseVerTurnosAdminLabel.setText("Ingrese la fecha del turno");
        }
    }
    @FXML
    void fieldSearchAppointmentAdmin (ActionEvent event) { //Field buscar en Ver Turnos

    }
    @FXML
    void clickSearchAppointmentAdmin (ActionEvent event){ //Botón buscar Turnos en Ver Turnos

        if (medicoVerTurnosAdminCheckBox.isSelected() && !BuscarVerTurnoAdminField.getText().isEmpty()) {
            //buscar por Doctor
            filtrarVerTurnosAdminAnchorPane.setVisible(false);
            mostrarVerTurnosAdminAnchorPane.setVisible(true);
            listaTurnosPacienteVerTurnosAdminAnchorPane.setVisible(false);
            listaTurnosFechaVerTurnosAdminAnchorPane.setVisible(false);
            listaTurnosMedicoVerTurnosAdminAnchorPane.setVisible(true);
            userMedicoVerTurnosLabel.setText(BuscarVerTurnoAdminField.getText());
            //tablaTurnosMedicoAdmin tabla a rellenar con los turnos del médico


            Medico medico = MedicoService.getInstance().retornaMedicoPorCampoTextField(BuscarVerTurnoAdminField.getText());

            List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medico);
            List <TurnoTabla> listaTurnos2 = new ArrayList<>();
            for(Turno turno : listaTurnos){
                Especialidad especialidad = turno.getMedico().getEspecialidad();
                Medico medico2 = turno.getMedico();
                Paciente paciente = turno.getPaciente();
                TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2, paciente, (paciente != null) ? paciente.getObraSocial() : null);

                listaTurnos2.add(turnoTabla);
            }

            columnaFechaTurnosMedico.setCellValueFactory(new PropertyValueFactory<>("dia"));
            columnaHoraTurnosMedico.setCellValueFactory(new PropertyValueFactory<>("hora"));
            columnaPacienteTurnosMedico.setCellValueFactory(new PropertyValueFactory<>("paciente"));
            columnaObraSocialTurnosMedico.setCellValueFactory(new PropertyValueFactory<>("obraSocial"));

            tablaTurnosMedicoAdmin.setItems(FXCollections.observableArrayList(listaTurnos2));


        } else if (pacienteVerTurnosAdminCheckBox.isSelected()&& !BuscarVerTurnoAdminField.getText().isEmpty()) {
            //buscar por Paciente
            filtrarVerTurnosAdminAnchorPane.setVisible(false);
            mostrarVerTurnosAdminAnchorPane.setVisible(true);
            listaTurnosPacienteVerTurnosAdminAnchorPane.setVisible(true);
            listaTurnosMedicoVerTurnosAdminAnchorPane.setVisible(false);
            listaTurnosFechaVerTurnosAdminAnchorPane.setVisible(false);
            userPacienteVerTurnosLabel.setText(BuscarVerTurnoAdminField.getText());
            //tablaTurnosPacienteAdmin tabla a rellenar con los turnos del paciente

            Paciente paciente = PacienteService.getInstance().retornaPacientePorCampoTextField(BuscarVerTurnoAdminField.getText());

            List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorPaciente(paciente);
            List <TurnoTabla> listaTurnos2 = new ArrayList<>();
            for(Turno turno : listaTurnos){
                Especialidad especialidad = turno.getMedico().getEspecialidad();
                Medico medico2 = turno.getMedico();
                TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2, paciente, (paciente != null) ? paciente.getObraSocial() : null);

                listaTurnos2.add(turnoTabla);
            }
            columnaFechaTurnosPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
            columnaHoraTurnosPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
            columnaMedicoTurnosPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));
            columnaEspecialidadTurnosPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

            tablaTurnosPacienteAdmin.setItems(FXCollections.observableArrayList(listaTurnos2));


        } else if (fechaVerTurnosAdminCheckBox.isSelected()&& !BuscarVerTurnoAdminField.getText().isEmpty()) {
            //buscar por Fecha
            filtrarVerTurnosAdminAnchorPane.setVisible(false);
            mostrarVerTurnosAdminAnchorPane.setVisible(true);
            listaTurnosFechaVerTurnosAdminAnchorPane.setVisible(true);
            listaTurnosPacienteVerTurnosAdminAnchorPane.setVisible(false);
            listaTurnosMedicoVerTurnosAdminAnchorPane.setVisible(false);
            fechaVerTurnosLabel.setText(BuscarVerTurnoAdminField.getText());
            //tablaTurnosFechaAdmin tabla a rellenar con los turnos de la fecha


            String fechaString = BuscarVerTurnoAdminField.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaString, formatter);

            List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorDia(fecha);
            List <TurnoTabla> listaTurnos2 = new ArrayList<>();

            for(Turno turno : listaTurnos){
                Especialidad especialidad = turno.getMedico().getEspecialidad();
                Medico medico2 = turno.getMedico();
                Paciente paciente = turno.getPaciente();
                TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2, paciente, (paciente != null) ? paciente.getObraSocial() : null);

                listaTurnos2.add(turnoTabla);
            }

            columnaHoraTurnosFecha.setCellValueFactory(new PropertyValueFactory<>("hora"));
            columnaMedicoTurnosFecha.setCellValueFactory(new PropertyValueFactory<>("medico"));
            columnaEspecialidadTurnosFecha.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
            columnaPacienteTurnosFecha.setCellValueFactory(new PropertyValueFactory<>("paciente"));

            tablaTurnosFechaAdmin.setItems(FXCollections.observableArrayList(listaTurnos2));


        } else {
            //no se seleccionó ningún criterio de búsqueda
            LoginController.showErrorAlert("Debe seleccionar un criterio de búsqueda");
        }



    }

    //[ MOSTRAR TURNOS ] PENDIENTE

    //HABILITAR TURNOS

    @FXML
    private void clickEnableAppointment (ActionEvent event){
        //cargar fields

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("H:mm");
        try{
            Medico medico = validarMedicoHabilitarTurnos(nombreYApellidoMedicoHabilitarTurnosField.getText());
            if(medico == null){
                throw new NullPointerException("No se encontro al medico");
            }
            LocalDate dia = validarFechaHabilitarTurnos(fechaHabilitarTurnosField.getText(), dateFormatter);
            if(dia.isBefore(LocalDate.now())){
                throw new DateTimeException("La fecha debe ser posterior al dia de hoy");
            }
            LocalTime horaInicio = validarHoraHabilitarTurnos(horaInicioHabilitarTurnosField.getText(), hourFormatter);
            LocalTime horaFin = validarHoraHabilitarTurnos(horaFinalizacionHabilitarTurnosField.getText(), hourFormatter);
            if(horaInicio.isBefore(LocalTime.of(9,0))){
                throw new DateTimeException("El horario inicial no puede ser anterior a las 9:00hs");
            }
            if(horaFin.isAfter(LocalTime.of(17, 30))){
                throw new DateTimeException("El horario final no puede excederse de las 17:30hs");
            }
            if(horaFin.isBefore(horaInicio)){
                throw new Exception("La hora de finalizacion no puede ser anterior a la hora de inicio");
            }
            TurnoService.getInstance().habilitarTurnos(dia, horaInicio, horaFin, medico);
            LoginController.showSuccessAlert("Turnos habilitados con exito!");
        }catch (NullPointerException e){
            LoginController.showErrorAlert(e.getMessage());
        }catch(DateTimeException e){
            LoginController.showErrorAlert(e.getMessage());
        }catch (Exception e){
            LoginController.showErrorAlert(e.getMessage());
        }
        finally{
            nombreYApellidoMedicoHabilitarTurnosField.setText("");
            fechaHabilitarTurnosField.setText("");
            horaInicioHabilitarTurnosField.setText("");
            horaFinalizacionHabilitarTurnosField.setText("");
        }


        //confirmar y guardar cambios

    }
    Medico validarMedicoHabilitarTurnos(String nombreYapellido){
        String input = nombreYapellido;
        String [] palabras = input.split(" ");
        String nombreMedico = palabras[0];
        StringBuilder apellidoMedicoBuilder = new StringBuilder();
        for(int i = 1; i < palabras.length; i++){
            if(i > 1){
                apellidoMedicoBuilder.append(" ");
            }
            apellidoMedicoBuilder.append(palabras[i]);
        }
        String apellidoMedico = apellidoMedicoBuilder.toString();
        return MedicoService.getInstance().buscarMedicoPorNombreYApellido(nombreMedico, apellidoMedico);
    }
    LocalDate validarFechaHabilitarTurnos(String dia, DateTimeFormatter formatter){
        LocalDate fecha = null;
        try{
            fecha = LocalDate.parse(dia, formatter);
        }catch (DateTimeParseException e){
            LoginController.showErrorAlert("La fecha ingresada no es valida");
        }
        return fecha;
    }
    LocalTime validarHoraHabilitarTurnos(String hora, DateTimeFormatter formatter){
        LocalTime horaR = null;
        try{
            horaR = LocalTime.parse(hora, formatter);
        }catch (DateTimeParseException e){
            LoginController.showErrorAlert("La hora ingresada no es valida");
        }
        return horaR;
    }



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

//EDITAR USUARIO//////////////////////////////////////////////////////////////////////////////////////////////

    //BUSCAR USUARIO//////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void clickSearchEdit(ActionEvent event) { //Botón Buscar en Buscar de Editar Usuario

        if(isMedicoBuscarEditarUsuarioCheckBox.isSelected()&& !isAdminBuscarEditarUsuarioCheckBox.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarEditarUsuarioAdminAnchorPane.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Medico")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarEditarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(listaFiltrada));
        }else if(!isMedicoBuscarEditarUsuarioCheckBox.isSelected()&& isAdminBuscarEditarUsuarioCheckBox.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarEditarUsuarioAdminAnchorPane.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Administrativo")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarEditarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(listaFiltrada));
        } else if (isMedicoBuscarEditarUsuarioCheckBox.isSelected()&& isAdminBuscarEditarUsuarioCheckBox.isSelected()) {
            showErrorAlert("Debe seleccionar solo un tipo de usuario para buscar");
        } else if (!isMedicoBuscarEditarUsuarioCheckBox.isSelected()&& !isAdminBuscarEditarUsuarioCheckBox.isSelected()) {
            cargarUsuariosEnTablaEditar();
        }

    }

    @FXML
    void clickConfirmUserEdit(ActionEvent event) { //Botón Confirmar en Mostrar de Editar Usuario
        ocultarTodosLosAnchorPane();
       // mostrarEditarUsuarioAdminAnchorPane.setVisible(false); // por las dudas la agregue
        editarUsuarioAdminAnchorPane.setVisible(true);
        edicionEditarUsuarioAdminAnchorPane.setVisible(true);
        agregarDatosAFieldEditarUsuario();
    }

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
        if(isMedicoBuscarEliminarUsuarioCheckBox.isSelected()&& !isAdminBuscarEliminarUsuarioCheckBox.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarEliminarUsuarioAdminAnchorPane.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Medico")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarEliminarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(listaFiltrada));
        }else if(!isMedicoBuscarEliminarUsuarioCheckBox.isSelected()&& isAdminBuscarEliminarUsuarioCheckBox.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarEliminarUsuarioAdminAnchorPane.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Administrativo")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarEliminarUsuarioAdminAnchorPane.setItems(FXCollections.observableArrayList(listaFiltrada));
        } else if (isMedicoBuscarEliminarUsuarioCheckBox.isSelected()&& isAdminBuscarEliminarUsuarioCheckBox.isSelected()) {
            showErrorAlert("Debe seleccionar solo un tipo de usuario para buscar");
        } else if (!isMedicoBuscarEliminarUsuarioCheckBox.isSelected()&& !isAdminBuscarEliminarUsuarioCheckBox.isSelected()) {
            cargarUsuariosEnTablaEliminar();
        }

    }

    public void tableDeleteUserAction(MouseEvent mouseEvent) {
        if(tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem() != null){
            mostrarEliminarUsuarioAdminAnchorPane.setVisible(true);
            buscarEliminarUsuarioAdminAnchorPane.setVisible(false);
            tipoUsuarioMostrarEliminarUsuarioAdminLabel.setText(tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getEntidad());
            usuarioMostrarEliminarUsuarioAdminLabel.setText(tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getUsuario());
            nombreMostrarEliminarUsuarioAdminLabel.setText(tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getNombre());
            apellidoMostrarEliminarUsuarioAdminLabel.setText(tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getApellido());
            String nombreUsuario= tablaBuscarEliminarUsuarioAdminAnchorPane.getSelectionModel().getSelectedItem().getUsuario();
            // recuperar el mail del usuario seleccionado

            Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
            Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);
            Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(nombreUsuario);
            if(medico.isPresent()){
                emailMostrarEliminarUsuarioAdminLabel.setText(medico.get().getMail());
                especialidadMostrarEliminarUsuarioAdminLabel.setText(medico.get().getEspecialidad().toString());
            }else if(administrativo.isPresent()){
                emailMostrarEliminarUsuarioAdminLabel.setText(administrativo.get().getMail());
            }else if(paciente.isPresent()){
                emailMostrarEliminarUsuarioAdminLabel.setText(paciente.get().getMail());
            }

        }
    }

    @FXML
    void clickConfirmUserDelete(ActionEvent event) { //Botón Confirmar en Eliminar Usuario
        String nombreUsuario = usuarioMostrarEliminarUsuarioAdminLabel.getText();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
        Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);
        if(medico.isPresent()){
            MedicoService.getInstance().darDeBajaMedico(medico.get());
        }else if(administrativo.isPresent()){
            AdministrativoService.getInstance().darDeBajaAdministrativo(administrativo.get());
        }
        showSuccessAlert("¡Usuario eliminado con éxito!");
        mostrarEliminarUsuarioAdminAnchorPane.setVisible(false);
        buscarEliminarUsuarioAdminAnchorPane.setVisible(true);
        cargarUsuariosEnTablaEliminar();

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

    @FXML
    void buttonCloseSessionAdmin(MouseEvent event) {
        SessionManager.getInstance().cerrarSesion();
        //volver a la vista principal
        LoginController.mostrarLogin();
    }

// ----------------------------     ACA METO FUNCIONES PARA DESTRABAR ERRORES -----------------------------




    @FXML
    void choiceSpecialityNewUser(KeyEvent event) {

    }

    /*@FXML
    void seleccionarMisTurnosAction(MouseEvent event) {

    }*/





}


