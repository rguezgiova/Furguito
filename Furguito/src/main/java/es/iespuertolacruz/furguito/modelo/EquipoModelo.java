package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EquipoModelo {
    SqliteBbdd persistencia;
    private static final String NOMBRE = "Equipos";
    private static final String CLAVE = "idEquipo";

    public EquipoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(NOMBRE, CLAVE, null, null);
    }

    public void insertarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.insertarEquipo(equipo);
    }

    public void modificarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.modificarEquipo(equipo);
    }

    public void eliminarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.borrarEquipo(equipo);
    }

    public Equipo consultarInformacion(String identificador) throws PersistenciaException {
        return persistencia.obtenerEquipo(identificador);
    }

    public void consultarPresupuesto(String identificador) throws PersistenciaException {
        persistencia.obtenerPresupuesto(identificador);
    }

    public void consultarCiudad(String identificador) throws PersistenciaException {
        persistencia.obtenerCiudad(identificador);
    }
}