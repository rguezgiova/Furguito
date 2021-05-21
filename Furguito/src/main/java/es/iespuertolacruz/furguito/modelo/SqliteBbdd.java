package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class SqliteBbdd extends Bbdd {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:furguito.db";

    public SqliteBbdd(String nombretabla, String clave, String driver, String url, String usuario, String password)
            throws PersistenciaException {
        super(nombretabla, clave, driver, url, usuario, password);
    }

    public SqliteBbdd(String nombretabla, String clave, String usuario, String password) throws PersistenciaException {
        super(nombretabla, clave, DRIVER, URL, usuario, password);
    }

}