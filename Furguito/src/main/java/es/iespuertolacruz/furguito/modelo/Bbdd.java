package es.iespuertolacruz.furguito.modelo;

import java.sql.*;

import es.iespuertolacruz.furguito.exception.BbddException;

public class Bbdd {
    private String driver;
    private String url;
    private String usuario;
    private String password;

    /**
     * Constructor con parametros
     * @param driver de la BBDD
     * @param url de la BBDD
     * @param usuario para el login
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
}