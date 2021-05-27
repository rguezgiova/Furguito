package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EstadioModelo {
    SqliteBbdd persistencia;
    private static final String TABLA = "Estadios";
    private static final String CLAVE = "idEstadio";
    private static final String SQLTABLE = "src/resources/sql/estadios-crear.sql";
    private static final String SQLINSERT = "src/resources/sql/estadios-insert.sql";

    public EstadioModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null, SQLTABLE, SQLINSERT);
    }

    /**
     * Inserta un estadio en la tabla
     * 
     * @param estadio objeto estadio
     * @throws PersistenciaException error controlado
     */
    public void insertarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.insertarEstadio(estadio);
    }

    /**
     * Modifica un estadio existente
     * 
     * @param estadio objeto estadio
     * @throws PersistenciaException error controlado
     */
    public void modificarEstadio(Estadio estadio) throws PersistenciaException {
        persistencia.modificarEstadio(estadio);
    }

    /**
     * Elimina un estadio de la tabla
     * 
     * @param id del estadio a borrar
     * @throws PersistenciaException error controlado
     */
    public void eliminarEstadio(int id) throws PersistenciaException {
        persistencia.borrarEstadio(id);
    }

    /**
     * Devuelve la informacion completa del estadio
     * 
     * @param nombre del estadio
     * @throws PersistenciaException error controlado
     */
    public void consultarInformacion(String nombre) throws PersistenciaException {
        persistencia.obtenerEstadio(nombre);
    }

    /**
     * Devuelve la capacidad del estadio buscado
     * 
     * @param nombre del estadio
     * @throws PersistenciaException error controlado
     */
    public void consultarCapacidad(String nombre) throws PersistenciaException {
        persistencia.obtenerCapacidad(nombre);
    }

    /**
     * Devuelve el anio de construccion de el estadio buscado
     * 
     * @param nombre del estadio
     * @throws PersistenciaException error controlado
     */
    public void consultarAnioConstruccion(String nombre) throws PersistenciaException {
        persistencia.obtenerAnio(nombre);
    }
}