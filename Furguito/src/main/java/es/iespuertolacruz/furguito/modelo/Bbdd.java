package es.iespuertolacruz.furguito.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.*;
import es.iespuertolacruz.furguito.exception.BbddException;

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
     * @throws BbddException error controlado
     */
    private Connection getConnection() throws BbddException {
        Connection connection = null;
        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer conexion con la BBDD", exception);
        }
        return connection;
    }

    /**
     * Funcion encargada de cerrar las conexiones con la BBDD
     * 
     * @param resultSet
     * @param connection
     * @param statement
     * @throws BbddException
     */
    private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
            throw new BbddException("Se ha producido un error cerrando la conexion", exception);
        }
    }

    /**
     * Funcion que realiza actualizaciones sobre la BBDD
     * 
     * @param sql de la consulta
     * 
     * @throws BbddException error controlado
     */
    private void actualizar(String sql) throws BbddException {

        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception exception) {
            throw new BbddException(ERROR_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Equipos
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException controlado
     */
    private ArrayList<Equipo> obtenerEquipos(String sql) throws BbddException {
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
            throw new BbddException(ERROR_CONSULTA, exception);
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
     * @throws BbddException controlado
     */
    private ArrayList<Estadio> obtenerEstadios(String sql) throws BbddException {
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
            throw new BbddException(ERROR_CONSULTA, exception);
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
     * @throws BbddException controlado
     */
    public ArrayList<Palmares> obtenerPalmares(String sql) throws BbddException {
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
            throw new BbddException(ERROR_CONSULTA, exception);
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
     * @throws BbddException controlado
     */
    public ArrayList<Jugador> obtenerJugadores(String sql) throws BbddException {
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
            throw new BbddException(ERROR_CONSULTA, exception);
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
     * @throws BbddException error controlado
     */
    public Equipo obtenerEquipo(String identificador) throws BbddException {
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
     * @throws BbddException error controlado
     */
    public Equipo obtenerPresupuesto(String identificador) throws BbddException {
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
     * @throws BbddException error controlado
     */
    public Equipo obtenerCiudad(String identificador) throws BbddException {
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
     * @throws BbddException error controlado
     */
    public void modificarEstadio(Estadio estadio) throws BbddException {
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
     * @throws BbddException error controlado
     */
    public void modificarEquipo(Equipo equipo) throws BbddException {
        String sql = "";
        sql = "UPDATE Equipo SET nombre = '" + equipo.getNombre() + "'" + ", ciudad = '" + equipo.getCiudad() + "'"
                + ", estadio = '" + equipo.getEstadio() + "'" + ", fundacion = '" + equipo.getFundacion()
                + ", numero_socios = '" + equipo.getNumeroSocios() + ", presupuesto = '" + equipo.getPresupuesto()
                + ", colores = '" + equipo.getColores() + "' WHERE identificador = '" + equipo.getId() + "'";
        actualizar(sql);
    }

    /**
     * Metodo para modificar el palmares de un equipo dentro de la BBDD
     * @param palmares a modificar
     * @throws BbddException error controlado
     */
    public void modificarPalmares(Palmares palmares) throws BbddException{
        String sql = "";
        sql = "UPDATE Palmares SET equipo = '"+palmares.getEquipo()+"'"+", ligas = '"
        +palmares.getLigas()+"'"+", copasDelRey = '"+palmares.getCopasDelRey()+"'"
        +", superEspana = '" +palmares.getSuperEspana()+", superEuropa = '" +palmares.getSuperEuropa()
        +", champions = '" +palmares.getChampions()+", mundialClubs = '" +palmares.getMundialClubs()
        +"' WHERE identificador = '"+palmares.getId()+"'";
        actualizar(sql);
    }

    /**
     * Metodo para modificar un jugador dentro de la BBDD
     * 
     * @param jugador a modificar
     * @throws BbddException error controlado
     */
    public void modificarJugador(Jugador jugador) throws BbddException {
        String sql = "";
        sql = "UPDATE Jugadores SET equipo = '"+jugador.getEquipo()+"'"+", nombre = '"
        +jugador.getNombre()+"'"+", dorsal = '"+jugador.getDorsal()+"'"
        +", goles = '" +jugador.getGoles()+", asistencias = '" +jugador.getAsistencias()
        +", amarillas = '" +jugador.getAmarillas()+", rojas = '" +jugador.getRojas()
        +"' WHERE identificador = '"+jugador.getId()+"'";
        actualizar(sql);
    }

}