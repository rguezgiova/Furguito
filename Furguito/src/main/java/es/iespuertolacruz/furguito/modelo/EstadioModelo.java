package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EstadioModelo {
    SqliteBbdd persistencia;
    private static final String NOMBRE = "Estadios";
    private static final String CLAVE = "idEstadio";

    public EstadioModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(NOMBRE, CLAVE, null, null);
    }

    public void insertarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.insertarEstadio(estadio);
    }

    public void modificarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.modificarEstadio(estadio);
    }

    public void eliminarEstadio(int id) throws PersistenciaException {
        persistencia.borrarEstadio(id);
    }

    public void consultarInformacion(String nombre) throws PersistenciaException {
        persistencia.obtenerEstadio(nombre);
    }

    public void consultarCapacidad(String nombre) throws PersistenciaException {
        persistencia.obtenerCapacidad(nombre);
    }

    public void consultarAnioConstruccion(String nombre) throws PersistenciaException {
        persistencia.obtenerAnio(nombre);
    }
}