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

    /**
     * Inserta el palmares de un equipo en la tabla
     * 
     * @param palmares a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.insertarPalmares(palmares);
    }

    /**
     * Modifica un palmares existente
     * 
     * @param palmares a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarPalmares(Palmares palmares) throws PersistenciaException {
        persistencia.modificarPalmares(palmares);
    }

    /**
     * Elimina el palmares del equipo
     * 
     * @param id del palmares a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminarPalmares(int id) throws PersistenciaException {
        persistencia.borrarPalmares(id);
    }

    /**
     * Consulta el palmares del equipo buscado
     * 
     * @param equipo nombre del equipo
     * @throws PersistenciaException error controlado
     */
    public void consultarPalmares(String equipo) throws PersistenciaException {
        persistencia.PalmaresEquipo(equipo);
    }

    /**
     * Devuelve a los 3 equipos con mas ligas
     * 
     * @throws PersistenciaException error controlado
     */
    public void consultarLigas() throws PersistenciaException {
        persistencia.PalmaresLigas();
    }

    /**
     * Devuelve los 3 equipos con mas copas del rey
     * 
     * @throws PersistenciaException error controlado
     */
    public void consultarCopas() throws PersistenciaException {
        persistencia.PalmaresCopas();
    }

}