package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.AuthenticationService;
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

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
    private PasswordField actualPasswordEdicionMiPerfilAdminField;

    @FXML
    private Label altaUsuarioLabel1;

    @FXML
    private AnchorPane altaUsuarioAdminAnchorPane1;

    @FXML
    private Label altaUsuarioAdminButton1;

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
    private Label apellidoMostrarAltaUsuarioAdminLabel1;

    @FXML
    private Label emailMostrarAltaUsuarioAdminLabel1;

    @FXML
    private Label especialidadMostrarAltaUsuarioAdminLabel1;

    @FXML
    private ChoiceBox<Especialidad> especialidadEdicionEditarUsuarioAdminChoiceBox;

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
    private AnchorPane buscarAltaUsuarioAdminAnchorPane1;

    @FXML
    private Button buscarEliminarUsuarioButton1;
    @FXML
    private AnchorPane buscarVerTurnosAdminAnchorPane;

    @FXML
    private Button buscarVerTurnosAdminButton;

    @FXML
    private Button cancelarEditarUsuarioButton;

    @FXML
    private Button cancelarEliminarUsuarioButton;

    @FXML

    private Button cancelarAltaUsuarioButton1;

    @FXML
    private Button confirmarAltaUsuarioAdminButton1;

   /* @FXML
    private PasswordField confirmNewPasswordEdicionEditarUsuarioAdminField;*/  /// preguntar a fede

    @FXML
    private PasswordField passwordEdicionEditarUsuarioAdminField;

    @FXML
    private PasswordField passwordEdicionMiPerfilAdminField;

    @FXML
    private TextField plainPasswordEdicionEditarUsuarioAdminField;

    @FXML
    private TextField plainPasswordEdicionMiPerfilAdminField;

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
    private TableColumn<?, ?> columnaUsuarioBuscarAltaUsuario1;

    @FXML
    private TableColumn<?, ?> columnaNombreBuscarAltaUsuario1;

    @FXML
    private TableColumn<?, ?> columnaApellidoBuscarAltaUsuario1;

    @FXML
    private TableColumn<?, ?> columnaTipoUsuarioBuscarAltaUsuario1;

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
    private AnchorPane filtrarAltaUsuarioAdminAnchorPane1;

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
    private CheckBox isMedicoBuscarAltaUsuarioCheckBox1;

    @FXML
    private CheckBox isAdminBuscarAltaUsuarioCheckBox1;

    @FXML
    private Label labelEspecialidadEditarUsuarioAdm;

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
    private ImageView mostrarPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView mostrarPasswordEdicionMiPerfilAdminButton;

    @FXML
    private AnchorPane mostrarEditarUsuarioAdminAnchorPane;


    @FXML
    private AnchorPane mostrarMiPerfilAdminAnchorPane;

    @FXML
    private ImageView mostrarPasswordNuevoUsuarioButton;

    @FXML
    private AnchorPane mostrarVerTurnosAdminAnchorPane;

    @FXML

    private AnchorPane mostrarAltaUsuarioAdminAnchorPane1;

    /*@FXML
    private PasswordField newPasswordEdicionEditarUsuarioAdminField;*/ // preguntar a fede

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
    private Label nombreMostrarAltaUsuarioAdminLabel1;

    @FXML
    private AnchorPane nuevoUsuarioAdminAnchorPane;

    @FXML
    private Label nuevoUsuarioAdminButton;

    @FXML
    private ImageView ocultarPasswordEdicionEditarUsuarioAdminButton;

    @FXML
    private ImageView ocultarPasswordEdicionMiPerfilAdminButton;

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
    private TableView<TablaUsuario> tablaBuscarAltaUsuarioAdminAnchorPane1;

    @FXML
    private Label tipoUsuarioMostrarEditarUsuarioAdminField;

    @FXML
    private Label tipoUsuarioMostrarEliminarUsuarioAdminLabel;

    @FXML
    private Label tipoUsuarioMostrarAltaUsuarioAdminLabel1;

    @FXML
    private Label usuarioMostrarAltaUsuarioAdminLabel1;

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

        bienvenidoAdminPanel.setVisible(true);
        altaUsuarioAdminAnchorPane1.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(false);
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();

        //especialidadEdicionEditarUsuarioAdminChoiceBox.getItems().addAll(Especialidad.values().toString());
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

        // ALTA USUARIO
        altaUsuarioAdminAnchorPane1.setVisible(false);
        buscarAltaUsuarioAdminAnchorPane1.setVisible(false);

    }


    @FXML
    void buttonMyProfileAdmin(MouseEvent event) { //Opción "Mi Perfil" de Menú-Admin
        ocultarTodosLosAnchorPane();
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
        ocultarTodosLosAnchorPane();
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
        ocultarTodosLosAnchorPane();
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
        ocultarTodosLosAnchorPane();
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


            Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
            Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);

            if(medico.isPresent()){
                emailMostrarEditarUsuarioAdminLabel.setText(medico.get().getMail());
                especialidadMostrarEditarUsuarioAdminLabel.setText(medico.get().getEspecialidad().toString());
            }else if(administrativo.isPresent()){
                emailMostrarEditarUsuarioAdminLabel.setText(administrativo.get().getMail());
                especialidadMostrarEditarUsuarioAdminLabel.setText(" ");
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
        ocultarTodosLosAnchorPane();

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

    @FXML
    void buttonAltaUserAdmin(MouseEvent event) { //Opción "Alta Usuario" de Menú-Admin
        ocultarTodosLosAnchorPane();

        buscarAltaUsuarioAdminAnchorPane1.setVisible(true);
        altaUsuarioAdminAnchorPane1.setVisible(true);
        cargarUsuariosEnTablaAlta();
    }

    public void cargarUsuariosEnTablaAlta() {
        Map <String, Usuario> listaAutenticables = new HashMap<>();

        Set<Medico> listaMedicos = MedicoService.getInstance().getMedicos();
        Set<Administrativo> listaAdministrativos = AdministrativoService.getInstance().getAdministrativos();
        Set<Paciente> listaPacientes = PacienteService.getInstance().getPacientes();

        for (Medico medico : listaMedicos) {
            if(!medico.getActivo()){
                listaAutenticables.put(medico.getNombreUsuario(), medico);
            }

        }
        for (Administrativo administrativo : listaAdministrativos) {
            if(!administrativo.getActivo()){
                listaAutenticables.put(administrativo.getNombreUsuario(), administrativo);
            }

        }
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
        columnaUsuarioBuscarAltaUsuario1.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        columnaNombreBuscarAltaUsuario1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidoBuscarAltaUsuario1.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaTipoUsuarioBuscarAltaUsuario1.setCellValueFactory(new PropertyValueFactory<>("entidad"));

        //cargar la lista de turnosTablaUsuario en la tabla
        tablaBuscarAltaUsuarioAdminAnchorPane1.setItems(FXCollections.observableArrayList(turnosTablaUsuario));

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
    void clickMostrarPasswordEdicionMiPerfilAdminButton(MouseEvent mouseEvent) {
        passwordEdicionMiPerfilAdminField.setVisible(false);
        plainPasswordEdicionMiPerfilAdminField.setText(passwordEdicionMiPerfilAdminField.getText());
        plainPasswordEdicionMiPerfilAdminField.setVisible(true);
        mostrarPasswordEdicionMiPerfilAdminButton.setVisible(true);
        ocultarPasswordEdicionMiPerfilAdminButton.setVisible(false);
    }

    @FXML
    void clickOcultarPasswordEdicionMiPerfilAdminButton(MouseEvent mouseEvent) {
        plainPasswordEdicionMiPerfilAdminField.setVisible(false);
        passwordEdicionMiPerfilAdminField.setText(plainPasswordEdicionMiPerfilAdminField.getText());
        passwordEdicionMiPerfilAdminField.setVisible(true);
        mostrarPasswordEdicionMiPerfilAdminButton.setVisible(false);
        ocultarPasswordEdicionMiPerfilAdminButton.setVisible(true);
    }

    @FXML
    void guardarEditarPerfilAdmin(ActionEvent event) {
        //se guardan los datos ingresados
        String nombre = nombreEdicionMiPerfilAdminField.getText();
        String apellido = apellidoEdicionMiPerfilAdminField.getText();
        String mail = emailEdicionMiPerfilAdminField.getText();
        String contrasena = passwordEdicionMiPerfilAdminField.getText();

        try {
            //se validan los datos ingresados
            ValidationService.getInstance().validarDatosEditarPerfilAdmin(nombre, apellido, mail, contrasena);
            //se recupera el usuario logueado
            String usuario = SessionManager.getInstance().getEntidadLogueada().getNombreUsuario();
            //se modifica la contraseña del usuario logueado
            AuthenticationService.getInstance().modificarContraseña(usuario, contrasena);
            //se modifica los restantes datos del usuario logueado en la lista de pacientes y el json
            AdministrativoService.getInstance().modificarAdministrativo(usuario, nombre, apellido, mail);
            //se setean los datos a mostrar en el perfil para esta sesión
            nombreMiPerfilAdminLabel.setText(nombre);
            apellidoMiPerfilAdminLabel.setText(apellido);
            emailMiPerfilAdminLabel.setText(mail);
            //se envía mensaje de éxito en la modificación
            LoginController.showSuccessAlert("Datos modificados exitosamente");
            //se muestra el perfil del admin
            mostrarPerfil();
        } catch (Exception e) {
        //se envía mensaje de error si se lanzó alguna excepción en las validaciones
        LoginController.showErrorAlert(e.getMessage());
        }
    }

    private void mostrarPerfil(){
        bienvenidoAdminPanel.setVisible(false);
        miPerfilAdminAnchorPane.setVisible(true);
        mostrarMiPerfilAdminAnchorPane.setVisible(true);
        editarMiPerfilAdminAnchorPane.setVisible(false);
        verTurnosAdminAnchorPane.setVisible(false);
        habilitarTurnosAdminAnchorPane.setVisible(false);
        nuevoUsuarioAdminAnchorPane.setVisible(false);
        editarUsuarioAdminAnchorPane.setVisible(false);
        eliminarUsuarioAdminAnchorPane.setVisible(false);
        altaUsuarioAdminAnchorPane1.setVisible(false);
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



    /*private void mostrarMedicoEnEditarUsuario (Optional<Medico> medic){
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
    }*/

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

        // si es medico se muestra la especialidad
        if (tipoUsuarioMostrarEditarUsuarioAdminField.getText().equalsIgnoreCase("Medico")) {

            labelEspecialidadEditarUsuarioAdm.setVisible(true);
            especialidadEdicionEditarUsuarioAdminChoiceBox.setVisible(true);
            //especialidadEdicionEditarUsuarioAdminChoiceBox.setValue(especialidadMostrarEditarUsuarioAdminLabel.getText());
            ///// ACA SE TIENEN QUE AGREGAR LOS DATOS DE LA ESPECIALIDAD EN EL CHOICEBOX
            especialidadEdicionEditarUsuarioAdminChoiceBox.getItems().addAll(Especialidad.values());



            System.out.println("ESPECIALIDADES: "+ Arrays.toString(Especialidad.values()));
        }else {
            especialidadEdicionEditarUsuarioAdminChoiceBox.setVisible(false);
            labelEspecialidadEditarUsuarioAdm.setVisible(false);
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

    public void choiceSpecialityUserEdit(KeyEvent keyEvent) {
    }

    @FXML
    void clickMostrarPasswordEdicionEditarUsuarioAdminButton(MouseEvent event) {
        passwordEdicionEditarUsuarioAdminField.setVisible(false);
        plainPasswordEdicionEditarUsuarioAdminField.setText(passwordEdicionEditarUsuarioAdminField.getText());
        plainPasswordEdicionEditarUsuarioAdminField.setVisible(true);
        mostrarPasswordEdicionEditarUsuarioAdminButton.setVisible(true);
        ocultarPasswordEdicionEditarUsuarioAdminButton.setVisible(false);
    }

    @FXML
    void clickOcultarPasswordEdicionEditarUsuarioAdminButton(MouseEvent event) {
        plainPasswordEdicionEditarUsuarioAdminField.setVisible(false);
        passwordEdicionEditarUsuarioAdminField.setText(plainPasswordEdicionEditarUsuarioAdminField.getText());
        passwordEdicionEditarUsuarioAdminField.setVisible(true);
        mostrarPasswordEdicionEditarUsuarioAdminButton.setVisible(false);
        ocultarPasswordEdicionEditarUsuarioAdminButton.setVisible(true);
    }

    @FXML
    void clickSaveUserEdit(ActionEvent event) { //Botón Guardar Cambios en Editar Usuario

            //se guardan los datos ingresados
            String nombre = nombreEdicionEditarUsuarioAdminField.getText();
            String apellido = apellidoEdicionEditarUsuarioAdminField.getText();
            String mail = emailEdicionEditarUsuarioAdminField.getText();
            String contrasena = passwordEdicionEditarUsuarioAdminField.getText();
            Especialidad especialidad = especialidadEdicionEditarUsuarioAdminChoiceBox.getValue();

            try {
                //se validan los datos ingresados
                ValidationService.getInstance().validarDatosEditarUsuario(nombre, apellido, mail, contrasena);
                //se verifica si el usuario que está siendo modificado es médico o administrativo
                Medico medico = MedicoService.getInstance().buscarMedicoPorNombreYApellido(nombreMostrarEditarUsuarioAdminLabel.getText(), apellidoMostrarEditarUsuarioAdminLabel.getText());
                Administrativo administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreYApellido(nombreMostrarEditarUsuarioAdminLabel.getText(), apellidoMostrarEditarUsuarioAdminLabel.getText());
                //si es medico se modifica la contraseña, en lista de medicos y el json
                if (medico != null) {
                    AuthenticationService.getInstance().modificarContraseña(medico.getNombreUsuario(), contrasena);
                    MedicoService.getInstance().modificarMedico(medico.getNombreUsuario(), nombre, apellido, mail, especialidad);
                }
                //si es administrativo se modifica la contraseña, en lista de administrativos y el json
                else if (administrativo != null) {
                    AuthenticationService.getInstance().modificarContraseña(administrativo.getNombreUsuario(), contrasena);
                    AdministrativoService.getInstance().modificarAdministrativo(administrativo.getNombreUsuario(), nombre, apellido, mail);
                }
                //se envía mensaje de éxito en la modificación
                LoginController.showSuccessAlert("Datos modificados exitosamente");
                ocultarTodosLosAnchorPane();
            } catch (Exception e) {
                LoginController.showErrorAlert(e.getMessage());
            }
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

  /*  private void mostrarMedicoEnEliminarUsuario (Optional<Medico> medico){
        tipoUsuarioMostrarEliminarUsuarioAdminLabel.setText("Médico");
        nombreMostrarEliminarUsuarioAdminLabel.setText(medico.get().getNombre());
        apellidoMostrarEliminarUsuarioAdminLabel.setText(medico.get().getApellido());
        emailMostrarEliminarUsuarioAdminLabel.setText(medico.get().getMail());
        especialidadEdicionEditarUsuarioAdminChoiceBox.setOnAction(event1-> {
            seleccionEspecialidad = Especialidad.valueOf(especialidadEdicionEditarUsuarioAdminChoiceBox.getValue());}); //CORREGIR ESTO
    }*/

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

    ////////////////////////////////     ALTA USUARIOS     -----------------------------


    @FXML
    void tableAltaUserAction(MouseEvent event) {
        if(tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem() != null){
            mostrarAltaUsuarioAdminAnchorPane1.setVisible(true);
            buscarAltaUsuarioAdminAnchorPane1.setVisible(false);
            tipoUsuarioMostrarAltaUsuarioAdminLabel1.setText(tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem().getEntidad());
            usuarioMostrarAltaUsuarioAdminLabel1.setText(tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem().getUsuario());
            nombreMostrarAltaUsuarioAdminLabel1.setText(tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem().getNombre());
            apellidoMostrarAltaUsuarioAdminLabel1.setText(tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem().getApellido());
            String nombreUsuario= tablaBuscarAltaUsuarioAdminAnchorPane1.getSelectionModel().getSelectedItem().getUsuario();
            // recuperar el mail del usuario seleccionado

            Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
            Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);
            Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(nombreUsuario);
            if(medico.isPresent()){
                emailMostrarAltaUsuarioAdminLabel1.setText(medico.get().getMail());
                especialidadMostrarAltaUsuarioAdminLabel1.setText(medico.get().getEspecialidad().toString());
            }else if(administrativo.isPresent()){
                emailMostrarAltaUsuarioAdminLabel1.setText(administrativo.get().getMail());
            }else if(paciente.isPresent()){
                emailMostrarAltaUsuarioAdminLabel1.setText(paciente.get().getMail());
            }

        }
    }

    @FXML
    void clickSearchUserAlta(ActionEvent event) {
        if(isMedicoBuscarAltaUsuarioCheckBox1.isSelected()&& !isAdminBuscarAltaUsuarioCheckBox1.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarAltaUsuarioAdminAnchorPane1.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Medico")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarAltaUsuarioAdminAnchorPane1.setItems(FXCollections.observableArrayList(listaFiltrada));
        }else if(!isMedicoBuscarAltaUsuarioCheckBox1.isSelected()&& isAdminBuscarAltaUsuarioCheckBox1.isSelected()){
            ObservableList<TablaUsuario> listaActual = tablaBuscarAltaUsuarioAdminAnchorPane1.getItems();
            List<TablaUsuario> listaFiltrada = new ArrayList<>();
            for (TablaUsuario usuario : listaActual) {
                if (usuario.getEntidad().equals("Administrativo")) {
                    listaFiltrada.add(usuario);
                }
            }
            tablaBuscarAltaUsuarioAdminAnchorPane1.setItems(FXCollections.observableArrayList(listaFiltrada));
        } else if (isMedicoBuscarAltaUsuarioCheckBox1.isSelected()&& isAdminBuscarAltaUsuarioCheckBox1.isSelected()) {
            showErrorAlert("Debe seleccionar solo un tipo de usuario para buscar");
        } else if (!isMedicoBuscarAltaUsuarioCheckBox1.isSelected()&& !isAdminBuscarAltaUsuarioCheckBox1.isSelected()) {
            cargarUsuariosEnTablaAlta();
        }
    }

    @FXML
    void clickConfirmUserAlta(ActionEvent event) {
        String nombreUsuario = usuarioMostrarAltaUsuarioAdminLabel1.getText();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(nombreUsuario);
        Optional<Administrativo> administrativo = AdministrativoService.getInstance().buscarAdministrativoPorNombreUsuario(nombreUsuario);
        if(medico.isPresent()){
            MedicoService.getInstance().darDeAltaMedico(medico.get());
        }else if(administrativo.isPresent()){
            AdministrativoService.getInstance().darDeAltaAdministrativo(administrativo.get());
        }
        showSuccessAlert("¡Usuario dado de alta con éxito!");
        cargarUsuariosEnTablaAlta();
        mostrarAltaUsuarioAdminAnchorPane1.setVisible(false);
        buscarAltaUsuarioAdminAnchorPane1.setVisible(true);

    }

    @FXML
    void clickCancelUserAlta(ActionEvent event) {
        //ocultarTodosLosAnchorPane();

        mostrarAltaUsuarioAdminAnchorPane1.setVisible(false);
        buscarAltaUsuarioAdminAnchorPane1.setVisible(true);
        cargarUsuariosEnTablaAlta();
    }
// ----------------------------     ACA METO FUNCIONES PARA DESTRABAR ERRORES -----------------------------


    @FXML
    void choiceSpecialityNewUser(KeyEvent event) {

    }

    /*@FXML
    void seleccionarMisTurnosAction(MouseEvent event) {

    }*/

}


