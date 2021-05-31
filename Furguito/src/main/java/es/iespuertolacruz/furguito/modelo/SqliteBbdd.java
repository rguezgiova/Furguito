package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class SqliteBbdd extends Bbdd {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:furguito.db";

    /**
     * Constructor con todos los parametros
     * 
     * @param nombreTabla nombre de la tabla
     * @param clave       clave de la tabla
     * @param driver      driver de conexion
     * @param url         de la BBDD
     * @param user        usuario
     * @param password    contrasenia
     * @throws PersistenciaException error controlado
     */
    public SqliteBbdd(String nombreTabla, String clave, String driver, String url, String user, String password)
            throws PersistenciaException {
        super(nombreTabla, clave, driver, url, user, password);
    }

    /**
     * Constructor que usa las constantes DRIVER y URL
     * 
     * @param nombreTabla nombre de la tabla
     * @param clave       clave de la tabla
     * @param usuario     usuario
     * @param password    contrasenia
     * @throws PersistenciaException error controlado
     */
    public SqliteBbdd(String nombreTabla, String clave, String usuario, String password) throws PersistenciaException {
        super(nombreTabla, clave, DRIVER, URL, usuario, password);
    }

}