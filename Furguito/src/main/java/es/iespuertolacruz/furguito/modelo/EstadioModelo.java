package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EstadioModelo {
    MysqlBbdd persistencia;

    public EstadioModelo() {
        persistencia = new MysqlBbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
    }
    
    public void insertarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.insertarEstadio(estadio);
    }

    public void modificarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.modificarEstadio(estadio);
    }

    public void eliminarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.borrarEstadio(estadio);
    }

    public void consultarInformacion() {
        persistencia.obte
    }

    public void consultarCapacidad() {
        persistencia.o
    }

    public void consultarAnioConstruccion() {
        persistencia.co
    }
}
