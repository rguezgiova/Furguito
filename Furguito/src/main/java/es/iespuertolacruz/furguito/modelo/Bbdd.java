package es.iespuertolacruz.furguito.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.BbddException;

public class Bbdd {
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
    private void closeConnection(ResultSet resultSet, Connection connection, Statement statement) throws BbddException {
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
     * Funcion que realiza la consulta sobre la BBDD y la tabla Equipos
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException controlado
     */
    private ArrayList<Equipo> obtenerListado(String sql) throws BbddException {
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
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(resultSet, connection, statement);
        }
        return listaEquipos;
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
        String sql = "SELECT * FROM Fruta where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerListado(sql);
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
        String sql = "SELECT nombre,presupuesto FROM Fruta where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerListado(sql);
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
        String sql = "SELECT nombre,ciudad FROM Fruta where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaEquipos = obtenerListado(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }

        return equipo;

    }

}