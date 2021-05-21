package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class PalmaresModelo {
    SqliteBbdd persistencia;
    private static final String NOMBRE = "Palmares";
    private static final String CLAVE = "idPalmares";

    public PalmaresModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(NOMBRE, CLAVE, null, null);
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