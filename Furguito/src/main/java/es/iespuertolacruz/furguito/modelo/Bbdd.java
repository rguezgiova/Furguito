package es.iespuertolacruz.furguito.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.*;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class Bbdd {
    private static final String ERROR_CONSULTA = "Se ha producido un error realizando la consulta";
    private String driver;
    private String url;
    private String usuario;
    private String password;

    /**
     * Constructor con parametros
     * 
     * @param driver   de la BBDD
     * @param url      de la BBDD
     * @param usuario  para el login
     * @param password del usuario
     */
    public Bbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Funcion encargada de realizar la operacion con la BBDD
     * 
     * @return la conexion
     * @throws PersistenciaException error controlado
     */
    private Connection getConnection() throws PersistenciaException {
        Connection connection = null;
        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("No se ha podido establecer conexion con la BBDD", exception);
        }
        return connection;
    }

    /**
     * Funcion encargada de cerrar las conexiones con la BBDD
     * 
     * @param resultSet
     * @param connection
     * @param statement
     * @throws PersistenciaException
     */
    private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error cerrando la conexion", exception);
        }
    }

    /**
     * Funcion que realiza actualizaciones sobre la BBDD
     * 
     * @param sql de la consulta
     * 
     * @throws PersistenciaException error controlado
     */
    private void actualizar(String sql) throws PersistenciaException {

        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Equipos
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    private ArrayList<Equipo> obtenerEquipos(String sql) throws PersistenciaException {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        Equipo equipo = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idEquipo");
                String nombre = resultSet.getString("nombre");
                String ciudad = resultSet.getString("ciudad");
                String estadio = resultSet.getString("estadio");
                int fundacion = resultSet.getInt("fundacion");
                int numeroSocios = resultSet.getInt("numero_socios");
                int presupuesto = resultSet.getInt("presupuesto");
                String colores = resultSet.getString("colores");
                equipo = new Equipo(nombre, ciudad, estadio, fundacion, numeroSocios, presupuesto, colores);
                listaEquipos.add(equipo);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaEquipos;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Estadios
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    private ArrayList<Estadio> obtenerEstadios(String sql) throws PersistenciaException {
        ArrayList<Estadio> listaEstadios = new ArrayList<>();

        Estadio estadio = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idEstadio");
                String nombre = resultSet.getString("nombre");
                String equipo = resultSet.getString("equipo");
                int capacidad = resultSet.getInt("capacidad");
                int construccion = resultSet.getInt("construccion");
                estadio = new Estadio(nombre, equipo, capacidad, construccion);
                listaEstadios.add(estadio);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaEstadios;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Palmares
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    public ArrayList<Palmares> obtenerPalmares(String sql) throws PersistenciaException {
        ArrayList<Palmares> listaPalmares = new ArrayList<>();
        Palmares palmares = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idPalmares");
                String equipo = resultSet.getString("equipo");
                int ligas = resultSet.getInt("ligas");
                int copasDelRey = resultSet.getInt("copasDelRey");
                int superEspana = resultSet.getInt("SuperEspana");
                int superEuropa = resultSet.getInt("SuperEuropa");
                int champions = resultSet.getInt("champions");
                int mundialClubs = resultSet.getInt("mundialClubs");
                palmares = new Palmares(equipo, ligas, copasDelRey, superEspana, superEuropa, champions, mundialClubs);
                listaPalmares.add(palmares);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaPalmares;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Jugadores
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    public ArrayList<Jugador> obtenerJugadores(String sql) throws PersistenciaException {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        Jugador jugador = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idJugador");
                String equipo = resultSet.getString("equipo");
                String nombre = resultSet.getString("nombre");
                int dorsal = resultSet.getInt("dorsal");
                int goles = resultSet.getInt("goles");
                int asistencias = resultSet.getInt("asistencias");
                int amarillas = resultSet.getInt("amarillas");
                int rojas = resultSet.getInt("rojas");
                jugador = new Jugador(equipo, nombre, dorsal, goles, asistencias, amarillas, rojas);
                listaJugadores.add(jugador);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaJugadores;
    }

    /**
     * Funcion que obtiene un equipo buscado por ID
     * 
     * @param identificador del equipo a buscar
     * @return equipo
     * @throws PersistenciaException error controlado
     */
    public Equipo obtenerEquipo(String identificador) throws PersistenciaException {
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos = null;
        String sql = "SELECT * FROM Equipos where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerEquipos(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }

        return equipo;

    }

    /**
     * Funcion que obtiene el nombre y el presupuesto del equipo buscado
     * 
     * @param identificador del equipo a buscar
     * @return equipo y presupuesto
     * @throws PersistenciaException error controlado
     */
    public Equipo obtenerPresupuesto(String identificador) throws PersistenciaException {
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos = null;
        String sql = "SELECT nombre,presupuesto FROM Equipos where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerEquipos(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }

        return equipo;

    }

    /**
     * Funcion que obtiene el nombre y la ciudad en la que juega el equipo buscado
     * 
     * @param identificador del equipo
     * @return nombre del equipo y ciudad
     * @throws PersistenciaException error controlado
     */
    public Equipo obtenerCiudad(String identificador) throws PersistenciaException {
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos = null;
        String sql = "SELECT nombre,ciudad FROM Equipos where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerEquipos(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }

        return equipo;

    }

    /**
     * Metodo para modificar un estadio dentro de la BBDD
     * 
     * @param estadio a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarEstadio(Estadio estadio) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE Estadios SET nombre = '" + estadio.getNombre() + "'" + ", equipo = '" + estadio.getEquipo() + "'"
                + ", capacidad = '" + estadio.getCapacidad() + "'" + ", construccion = '" + estadio.getConstruccion()
                + "' WHERE identificador = '" + estadio.getId() + "'";
        actualizar(sql);
    }

    /**
     * Metodo para modificar un equipo dentro de la BBDD
     * 
     * @param equipo a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarEquipo(Equipo equipo) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE Equipo SET nombre = '" + equipo.getNombre() + "'" + ", ciudad = '" + equipo.getCiudad() + "'"
                + ", estadio = '" + equipo.getEstadio() + "'" + ", fundacion = '" + equipo.getFundacion()
                + ", numero_socios = '" + equipo.getNumeroSocios() + ", presupuesto = '" + equipo.getPresupuesto()
                + ", colores = '" + equipo.getColores() + "' WHERE identificador = '" + equipo.getId() + "'";
        actualizar(sql);
    }

    /**
     * Metodo para modificar el palmares de un equipo dentro de la BBDD
     * 
     * @param palmares a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarPalmares(Palmares palmares) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE Palmares SET equipo = '" + palmares.getEquipo() + "'" + ", ligas = '" + palmares.getLigas() + "'"
                + ", copasDelRey = '" + palmares.getCopasDelRey() + "'" + ", superEspana = '"
                + palmares.getSuperEspana() + ", superEuropa = '" + palmares.getSuperEuropa() + ", champions = '"
                + palmares.getChampions() + ", mundialClubs = '" + palmares.getMundialClubs()
                + "' WHERE identificador = '" + palmares.getId() + "'";
        actualizar(sql);
    }

    /**
     * Metodo para modificar un jugador dentro de la BBDD
     * 
     * @param jugador a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarJugador(Jugador jugador) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE Jugadores SET equipo = '" + jugador.getEquipo() + "'" + ", nombre = '" + jugador.getNombre() + "'"
                + ", dorsal = '" + jugador.getDorsal() + "'" + ", goles = '" + jugador.getGoles() + ", asistencias = '"
                + jugador.getAsistencias() + ", amarillas = '" + jugador.getAmarillas() + ", rojas = '"
                + jugador.getRojas() + "' WHERE identificador = '" + jugador.getId() + "'";
        actualizar(sql);
    }

    /**
     * Metodo que se encarga de la insercion de un estadio en la BBDD
     * 
     * @param estadio a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarEstadio(Estadio estadio) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO Estadios (nombre, equipo, capacidad, construccion) VALUES('" + estadio.getNombre()
                + "', '" + estadio.getEquipo() + "', '" + estadio.getCapacidad() + "', '" + estadio.getConstruccion()
                + "')";
        actualizar(sql);
    }

    /**
     * Metodo que se encarga de la insercion de un equipo en la BBDD
     * 
     * @param equipo a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarEquipo(Equipo equipo) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO Equipos (nombre, ciudad, estadio, fundacion, numero_socios, presupuesto, colores) VALUES('" 
                + equipo.getNombre() + "', '" + equipo.getCiudad() + "', '" + equipo.getEstadio() + "', '"
                + equipo.getFundacion() + "', " + equipo.getNumeroSocios() + "', " + equipo.getPresupuesto() + "', "
                + equipo.getColores() + "')";
        actualizar(sql);
    }

    /**
     * Metodo que se encarga de la insercion del palmares de un equipo en la BBDD
     * 
     * @param palmares a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarPalmares(Palmares palmares) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO Palmares (equipo, ligas, copasDelRey, superEspana, SuperEuropa, champions, mundialClubs) VALUES('" 
                + palmares.getEquipo() + "', '" + palmares.getLigas() + "', '" + palmares.getCopasDelRey()
                + "', '" + palmares.getSuperEspana() + "', " + palmares.getSuperEuropa() + "', "
                + palmares.getChampions() + "', " + palmares.getMundialClubs() + "')";
        actualizar(sql);
    }

    /**
     * Metodo que se encarga de la insercion de un jugador en la BBDD
     * 
     * @param jugador a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarJugador(Jugador jugador) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO Jugadores (equipo, nombre, dorsal, goles, asistencias, amarillas, rojas) VALUES('"
                + jugador.getEquipo() + "', '" + jugador.getNombre() + "', '" + jugador.getDorsal() + "', '"
                + jugador.getGoles() + "', " + jugador.getAsistencias() + "', " + jugador.getAmarillas() + "', "
                + jugador.getRojas() + "')";
        actualizar(sql);
    }

    /**
     * Metodo para borrar un equipo de la BBDD
     * 
     * @param equipo a borrar
     * @throws PersistenciaException error controlado
     */
    public void borrarEquipo(Equipo equipo) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM Equipos WHERE idEquipo = " + equipo.getId();
        actualizar(sql);
    }

    /**
     * Metodo para borrar un estadio de la BBDD
     * 
     * @param estadio a borrar
     * @throws PersistenciaException error controlado
     */
    public void borrarEstadio(Estadio estadio) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM Estadios WHERE idEstadio = " + estadio.getId();
        actualizar(sql);
    }

    /**
     * Metodo para borrar un palmares de la BBDD
     * 
     * @param palmares a borrar
     * @throws PersistenciaException error controlado
     */
    public void borrarPalmares(Palmares palmares) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM Palmares WHERE idPalmares = " + palmares.getId();
        actualizar(sql);
    }

    /**
     * Metodo para borrar un jugador de la BBDD
     * 
     * @param jugador a borrar
     * @throws PersistenciaException error controlado
     */
    public void borrarJugador(Jugador jugador) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM Jugadores WHERE idJugador = " + jugador.getId();
        actualizar(sql);
    }
}