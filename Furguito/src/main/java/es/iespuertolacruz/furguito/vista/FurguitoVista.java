package es.iespuertolacruz.furguito.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.controller.EquipoController;
import es.iespuertolacruz.furguito.controller.EstadioController;
import es.iespuertolacruz.furguito.controller.JugadorController;
import es.iespuertolacruz.furguito.controller.PalmaresController;
import es.iespuertolacruz.furguito.exception.EquipoException;
import es.iespuertolacruz.furguito.exception.EstadioException;
import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.exception.PalmaresException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class FurguitoVista {
    private static final String INTRODUCIR_NUMERO = "Debe introducir un numero";
    private static final String SEPARADOR = "##########################\n";
    private static final String ESCRIBE_OPCIONES = "Escribe una de las opciones:";
    private static final String ADMIN = "admin";
    static EquipoController equipoController;
    static JugadorController jugadorController;
    static PalmaresController palmaresController;
    static EstadioController estadioController;

    /**
     * Metodo principal de la clase vista
     * 
     * @throws PersistenciaException error controlado
     * @throws EquipoException       error controlado
     * @throws EstadioException      error controlado
     * @throws JugadorException      error controlado
     * @throws PalmaresException     error controlado
     */

    public FurguitoVista() {
        try {
            equipoController = new EquipoController();
        } catch (PersistenciaException exception) {
            exception.printStackTrace();
        }
        try {
            palmaresController = new PalmaresController();
        } catch (PersistenciaException exception) {
            exception.printStackTrace();
        }
        try {
            estadioController = new EstadioController();
        } catch (PersistenciaException exception) {
            exception.printStackTrace();
        }
        try {
            jugadorController = new JugadorController();
        } catch (PersistenciaException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args)
            throws PersistenciaException, EquipoException, EstadioException, JugadorException, PalmaresException {

        new FurguitoVista();
        menuPrincipal();

    }

    /**
     * Menu principal de la vista
     * 
     * @throws PersistenciaException
     * @throws EquipoException
     * @throws EstadioException
     * @throws JugadorException
     * @throws PalmaresException
     */
    public static void menuPrincipal()
            throws PersistenciaException, EquipoException, EstadioException, JugadorException, PalmaresException {
        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("##Bienvenido a Furguito##");
            System.out.println(SEPARADOR);
            System.out.println("1. Entrar como invitado");
            System.out.println("2. Entrar como administrador");
            System.out.println("3. Salir");

            try {
                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Entrar como invitado");
                        System.out.println(SEPARADOR);
                        menuInvitado();
                        break;
                    case 2:
                        System.out.println("Entrar como administrador");
                        System.out.println(SEPARADOR);
                        String usuario = null;
                        String password = null;
                        System.out.println("Introduzca el usuario:");
                        usuario = sn.next();
                        System.out.println("Introduzca la contraseña:");
                        password = sn.next();
                        if (!usuario.equals(ADMIN) && !password.equals(ADMIN)) {
                            System.out.println("Validacion incorrecta");
                            System.out.println("Accediendo como invitado");
                            System.out.println(SEPARADOR);
                            menuInvitado();
                        } else {
                            System.out.println("Accediendo como administrador");
                            System.out.println(SEPARADOR);
                            menuAdmin();
                        }
                        break;
                    case 3:
                        System.out.println("Gracias por usar Furguito");
                        System.out.println(SEPARADOR);
                        salir = true;
                        break;
                    default:
                        System.out.println(INTRODUCIR_NUMERO);
                }
            } catch (InputMismatchException e) {
                System.out.println(INTRODUCIR_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Metodo con las opciones de los usuarios administradores
     * 
     * @throws PersistenciaException error controlado
     * @throws EquipoException       error controlado
     * @throws EstadioException      error controlado
     * @throws JugadorException      error controlado
     * @throws PalmaresException     error controlado
     */
    public static void menuAdmin()
            throws PersistenciaException, EquipoException, EstadioException, JugadorException, PalmaresException {

        Scanner sn = new Scanner(System.in);
        int id;
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("1- Insertar club");
            System.out.println("2- Modificar club");
            System.out.println("3- Borrar club");
            System.out.println("4- Insertar estadio");
            System.out.println("5- Modificar estadio");
            System.out.println("6- Borrar estadio");
            System.out.println("7- Insertar jugador");
            System.out.println("8- Modificar jugador");
            System.out.println("9- Borrar jugador");
            System.out.println("10- Insertar palmares");
            System.out.println("11- Modificar palmares");
            System.out.println("12- Borrar palmares");
            System.out.println("13- Salir");

            try {
                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Insertar club");
                        equipoController.insertarEquipo(pedirDatosEquipos());
                        break;
                    case 2:
                        System.out.println("Modificar club");
                        equipoController.modificarEquipo(pedirDatosEquipos());
                        break;
                    case 3:
                        System.out.println("Borrar club");
                        System.out.println("Introduzca el id del equipo:");
                        id = sn.nextInt();
                        equipoController.eliminarEquipo(id);
                        break;
                    case 4:
                        System.out.println("Insertar estadio");
                        estadioController.insertarEstadio(pedirDatosEstadio());
                        break;
                    case 5:
                        System.out.println("Modificar estadio");
                        estadioController.modificarEstadio(pedirDatosEstadio());
                        break;
                    case 6:
                        System.out.println("Borrar estadio");
                        System.out.println("Introduzca el id del estadio:");
                        id = sn.nextInt();
                        estadioController.eliminarEstadio(id);
                        break;
                    case 7:
                        System.out.println("Insertar jugador");
                        jugadorController.insertarJugador(pedirDatosJugador());
                        break;
                    case 8:
                        System.out.println("Modificar jugador");
                        jugadorController.modificarJugador(pedirDatosJugador());
                        break;
                    case 9:
                        System.out.println("Borrar jugador");
                        System.out.println("Introduzca el id del jugador:");
                        id = sn.nextInt();
                        jugadorController.eliminarJugador(id);
                        break;
                    case 10:
                        System.out.println("Insertar palmares");
                        palmaresController.insertarPalmares(pedirDatosPalmares());
                        break;
                    case 11:
                        System.out.println("Modificar palmares");
                        palmaresController.modificarPalmares(pedirDatosPalmares());
                        break;
                    case 12:
                        System.out.println("Borrar palmares");
                        System.out.println("Introduzca el id del palmares:");
                        id = sn.nextInt();
                        palmaresController.eliminarPalmares(id);
                        break;
                    case 13:
                        System.out.println(SEPARADOR);
                        salir = true;
                        break;
                    default:
                        System.out.println(INTRODUCIR_NUMERO);
                }
            } catch (InputMismatchException e) {
                System.out.println(INTRODUCIR_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Metodo con las opciones de los usuarios invitados
     * 
     * @throws PersistenciaException error controlado
     */
    public static void menuInvitado() throws PersistenciaException {

        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        String nombre;
        while (!salir) {
            System.out.println("1- Informacion del club");
            System.out.println("2- Consultar presupuesto del club");
            System.out.println("3- Consultar ciudad del club");
            System.out.println("4- Informacion del estadio");
            System.out.println("5- Capacidad del estadio");
            System.out.println("6- Fecha de construccion del estadio");
            System.out.println("7- Informacion del jugador");
            System.out.println("8- Top 5 maximos goleadores");
            System.out.println("9- Top 10 jugadores mas expulsados");
            System.out.println("10- Consultar palmares");
            System.out.println("11- Equipos con mas ligas");
            System.out.println("12- Equipos con mas copas");
            System.out.println("13- Salir");

            try {
                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Informacion del club");
                        System.out.println("Introduzca el nombre del club:");
                        nombre = sn.next();
                        equipoController.consultarInformacion(nombre);
                        break;
                    case 2:
                        System.out.println("Consultar presupuesto del club");
                        System.out.println("Introduzca el nombre del club:");
                        nombre = sn.next();
                        equipoController.consultarPresupuesto(nombre);
                        break;
                    case 3:
                        System.out.println("Consultar ciudad del club");
                        System.out.println("Introduzca el nombre del club:");
                        nombre = sn.next();
                        equipoController.consultarCiudad(nombre);
                        break;
                    case 4:
                        System.out.println("Informacion del estadio");
                        System.out.println("Introduzca el nombre del estadio:");
                        nombre = sn.next();
                        estadioController.consultarInformacion(nombre);
                        break;
                    case 5:
                        System.out.println("Capacidad del estadio");
                        System.out.println("Introduzca el nombre del estadio:");
                        nombre = sn.next();
                        estadioController.consultarCapacidad(nombre);
                        break;
                    case 6:
                        System.out.println("Fecha de construccion del estadio");
                        System.out.println("Introduzca el nombre del estadio:");
                        nombre = sn.next();
                        estadioController.consultarAnioConstruccion(nombre);
                        break;
                    case 7:
                        System.out.println("Informacion del jugador");
                        System.out.println("Introduzca el nombre del jugador:");
                        nombre = sn.next();
                        jugadorController.consultarInformacion(nombre);
                        break;
                    case 8:
                        System.out.println("Top 5 maximos goleadores");
                        jugadorController.consultarMaximosGoleadores();
                        break;
                    case 9:
                        System.out.println("Top 10 jugadores mas expulsados");
                        jugadorController.consultarMasExpulsados();
                        break;
                    case 10:
                        System.out.println("Consultar palmares");
                        System.out.println("Introduzca el nombre del equipo:");
                        nombre = sn.next();
                        palmaresController.consultarPalmares(nombre);
                        break;
                    case 11:
                        System.out.println("Equipos con mas ligas");
                        palmaresController.consultarLigas();
                        break;
                    case 12:
                        System.out.println("Equipos con mas copas");
                        palmaresController.consultarCopas();
                        break;
                    case 13:
                        System.out.println(SEPARADOR);
                        salir = true;
                        break;
                    default:
                        System.out.println(INTRODUCIR_NUMERO);
                }
            } catch (InputMismatchException e) {
                System.out.println(INTRODUCIR_NUMERO);
                sn.next();

            }
        }
    }

    /**
     * Funcion encargada de pedir los datos del objeto equipo
     * 
     * @return objeto equipo con sus datos
     */
    private static Equipo pedirDatosEquipos() {
        int id;
        String nombre;
        String ciudad;
        String estadio;
        int fundacion;
        int numeroSocios;
        double presupuesto;
        String colores;

        Scanner sn = new Scanner(System.in);
        System.out.println("Introduzca el ID del equipo");
        id = sn.nextInt();
        System.out.println("Introduzca el nombre del equipo");
        nombre = sn.next();
        System.out.println("Introduzca la ciudad del equipo");
        ciudad = sn.next();
        System.out.println("Introduzca el estadio del equipo");
        estadio = sn.next();
        System.out.println("Introduzca el anio de fundacion del equipo");
        fundacion = sn.nextInt();
        System.out.println("Introduzca el numero de socios del equipo");
        numeroSocios = sn.nextInt();
        System.out.println("Introduzca el presupuesto anual del equipo");
        presupuesto = sn.nextDouble();
        System.out.println("Introduzca los colores del equipo");
        colores = sn.next();
        Equipo equipo = new Equipo(id, nombre, ciudad, estadio, fundacion, numeroSocios, presupuesto, colores);
        return equipo;
    }

    /**
     * Funcion encargada de pedir los datos del objeto estadio
     * 
     * @return objeto estadio con sus datos
     */
    private static Estadio pedirDatosEstadio() {
        int id;
        String nombre;
        String equipo;
        int capacidad;
        int construccion;

        Scanner sn = new Scanner(System.in);
        System.out.println("Introduzca el ID del estadio");
        id = sn.nextInt();
        System.out.println("Introduzca el nombre del estadio");
        nombre = sn.next();
        System.out.println("Introduzca el equipo al que pertenece el estadio");
        equipo = sn.next();
        System.out.println("Introduzca la capacidad del estadio");
        capacidad = sn.nextInt();
        System.out.println("Introduzca el anio construccion del estadio");
        construccion = sn.nextInt();
        Estadio estadio = new Estadio(id, nombre, equipo, capacidad, construccion);
        return estadio;
    }

    /**
     * Funcion encargada de pedir los datos del objeto jugador
     * 
     * @return objeto jugador con sus datos
     */
    private static Jugador pedirDatosJugador() {
        int id;
        String equipo;
        String nombre;
        int dorsal;
        int goles;
        int asistencias;
        int amarillas;
        int rojas;

        Scanner sn = new Scanner(System.in);
        System.out.println("Introduzca el ID del jugador");
        id = sn.nextInt();
        System.out.println("Introduzca el equipo al que pertenece el jugador");
        equipo = sn.next();
        System.out.println("Introduzca el nombre del jugador");
        nombre = sn.next();
        System.out.println("Introduzca el dorsal del jugador");
        dorsal = sn.nextInt();
        System.out.println("Introduzca el numero de goles del jugador");
        goles = sn.nextInt();
        System.out.println("Introduzca el numero de asistencias del jugador");
        asistencias = sn.nextInt();
        System.out.println("Introduzca el numero de tarjetas amarillas del jugador");
        amarillas = sn.nextInt();
        System.out.println("Introduzca el numero de tarjetas rojas del jugador");
        rojas = sn.nextInt();
        Jugador jugador = new Jugador(id, equipo, nombre, dorsal, goles, asistencias, amarillas, rojas);
        return jugador;
    }

    /**
     * Funcion encargada de pedir los datos del objeto palmares
     * 
     * @return objeto palmares con sus datos
     */
    private static Palmares pedirDatosPalmares() {
        int id;
        String equipo;
        int ligas;
        int copasDelRey;
        int superEspana;
        int superEuropa;
        int champions;
        int mundialClubs;

        Scanner sn = new Scanner(System.in);
        System.out.println("Introduzca el ID del palmares");
        id = sn.nextInt();
        System.out.println("Introduzca el equipo al que pertenece el palmares");
        equipo = sn.next();
        System.out.println("Introduzca el numero de Ligas");
        ligas = sn.nextInt();
        System.out.println("Introduzca el numero de Copas del Rey");
        copasDelRey = sn.nextInt();
        System.out.println("Introduzca el numero de Supercopas de Espania");
        superEspana = sn.nextInt();
        System.out.println("Introduzca el numero de Supercopas de Europa");
        superEuropa = sn.nextInt();
        System.out.println("Introduzca el numero de Champions League");
        champions = sn.nextInt();
        System.out.println("Introduzca el numero de Mundiales de clubs");
        mundialClubs = sn.nextInt();

        Palmares palmares = new Palmares(id, equipo, ligas, copasDelRey, superEspana, superEuropa, champions,
                mundialClubs);
        return palmares;
    }
}