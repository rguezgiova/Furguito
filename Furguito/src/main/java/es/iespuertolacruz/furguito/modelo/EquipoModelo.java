package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EquipoModelo {
    SqliteBbdd persistencia;

    public EquipoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(null, null);
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

    public void consultarInformacion(String identificador) throws PersistenciaException {
        persistencia.obtenerEquipo(identificador);
    }

    public void consultarPresupuesto(String identificador) throws PersistenciaException {
        persistencia.obtenerPresupuesto(identificador);
    }

    public void consultarCiudad(String identificador) throws PersistenciaException {
        persistencia.obtenerCiudad(identificador);
    }
}
