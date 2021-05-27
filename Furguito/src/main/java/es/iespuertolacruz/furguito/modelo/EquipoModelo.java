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

    /**
     * Insertar un equipo en la tabla de Equipos
     * 
     * @param equipo a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.insertarEquipo(equipo);
    }

    /**
     * Modificar un equipo en la tabla Equipos
     * 
     * @param equipo a modificar
     * @throws PersistenciaExcepion error controlado
     */
    public void modificarEquipo(Equipo equipo) throws PersistenciaException {
        persistencia.modificarEquipo(equipo);
    }

    /**
     * Eliminar un equipo de la tabla Equipos
     * 
     * @param equipo a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminarEquipo(int id) throws PersistenciaException {
        persistencia.borrarEquipo(id);
    }

    /**
     * Consultar la informacion de un equipo especifico
     * 
     * @param nombre del equipo
     * @return datos del equipo
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarInformacion(String nombre) throws PersistenciaException {
        return persistencia.obtenerEquipo(nombre);
    }

    /**
     * Consultar en que ciudad juega el equipo buscado
     * 
     * @param nombre del equipo
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarCiudad(String nombre) throws PersistenciaException {
        return persistencia.consultarCiudad(nombre);
    }
}