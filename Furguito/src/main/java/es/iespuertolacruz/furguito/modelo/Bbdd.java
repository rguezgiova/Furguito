package es.iespuertolacruz.furguito.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class Bbdd {
    private static final String NOMBRE_TABLAS = "Equipos,Jugadores,Estadios,Palmares";
    private static final String TABLE = "TABLE";
    private static final String TABLE_NAME = "TABLE_NAME";
    protected String nombretabla;
    protected String clave;
    protected String driver;
    protected String url;
    protected String usuario;
    protected String password;
    protected String slqTable;
    protected String sqlInsert;

    /**
     * Constructor con parametros
     * 
     * @param driver   de la BBDD
     * @param url      de la BBDD
     * @param usuario  para el login
     * @param password del usuario
     * @throws PersistenciaException
     */
    public Bbdd(String nombretabla, String clave, String driver, String url, String usuario, String password,
            String sqlTable, String sqlInsert) throws PersistenciaException {
        this.nombretabla = nombretabla;
        this.clave = clave;
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        this.slqTable = sqlTable;
        this.sqlInsert = sqlInsert;
        init(nombretabla);
    }

    /**
     * Metodo que crea la BBDD e inserta los datos iniciales
     * 
     * @throws PersistenciaException error controlado
     */
    private void init(String nombreTabla) throws PersistenciaException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();
        String[] convertir = NOMBRE_TABLAS.split(",");
        List<String> nombreTablas = Arrays.asList(convertir);

        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] { TABLE });
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString(TABLE_NAME));
            }
            for (String tabla : nombreTablas) {
                if (!listaTablas.contains(tabla)) {
                    actualizar(slqTable);
                    actualizar(sqlInsert);
                }
            }
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConnection(connection, null, resultSet);
        }
    }

    /**
     * Funcion encargada de realizar la operacion con la BBDD
     * 
     * @return la conexion
     * @throws PersistenciaException error controlado
     */
    public Connection getConnection() throws PersistenciaException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, usuario, password);
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
    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet)
            throws PersistenciaException {
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
     * @throws PersistenciaException error controlado
     */
    public void actualizar(String sql) throws PersistenciaException {
        PreparedStatement statement;
        Connection connection;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error en la consulta ", exception);
        }
    }

    /**
     * Metodo que busca elementos de una sentencia
     * 
     * @param sql con la sentencia
     * @return resultados
     * @throws PersistenciaException error controlado
     */
    protected ResultSet buscarElementos(String sql) throws PersistenciaException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error en la busqueda");
        }
        return resultSet;
    }
}