package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class PalmaresModelo {
    SqliteBbdd persistencia;

    public PalmaresModelo() {
        persistencia = new SqliteBbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
    }

    public void insertarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.insertarPalmares(palmares);
    }

    public void modificarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.modificarPalmares(palmares);
    }

    public void eliminarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.borrarPalmares(palmares);
    }

    public void consultarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.obtenerPalmares(palmares.getId());
    }

    
}
