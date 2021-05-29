package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class SqliteBbdd extends Bbdd {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:furguito.db";

    public SqliteBbdd(String nombreTabla, String clave, String driver, String url, String user, String password) throws PersistenciaException {
        super(nombreTabla, clave, driver, url, user, password);
    }

    public SqliteBbdd(String nombreTabla, String clave, String usuario, String password) throws PersistenciaException {
        super(nombreTabla, clave, DRIVER, URL, usuario, password);
    }

}