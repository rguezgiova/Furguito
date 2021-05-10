package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EquipoModelo {
    MysqlBbdd persistencia;

    public EquipoModelo() {
        persistencia = new MysqlBbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
    }
    
    public void insertarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.insertarEquipo(equipo);
    }

    public void modificarEquipo() {

    }

    public void eliminarEquipo() {

    }

    public void consultarInformacion() {

    }

    public void consultarPresupuesto() {

    }

    public void consultarCiudad() {

    }
}
