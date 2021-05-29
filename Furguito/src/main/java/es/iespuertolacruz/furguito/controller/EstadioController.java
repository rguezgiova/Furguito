package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.EstadioException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.EstadioModelo;

public class EstadioController {
    EstadioModelo estadioModelo;

    public EstadioController() throws PersistenciaException {
        if (estadioModelo == null) {
            estadioModelo = new EstadioModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del objeto estadio
     * 
     * @param estadio a validar
     * @throws EstadioException error controlado
     */
    public void validar(Estadio estadio) throws EstadioException {
        String mensaje = "";
        if (estadio == null) {
            mensaje = "Se esta intentando validar un objeto nulo";
            throw new EstadioException(mensaje);
        }
        if (estadio.getId() <= 0) {
            mensaje += "El id del estadio no puede ser menor o igual a 0 \n";
        }
        if (estadio.getNombre() == null || estadio.getNombre().isEmpty()) {
            mensaje += "El nombre del estadio no puede ser nulo o vacio \n";
        }
        if (estadio.getEquipo() == null || estadio.getEquipo().isEmpty()) {
            mensaje += "El nombre del equipo no puede ser nulo o vacio";
        }
        if (!mensaje.isEmpty()) {
            throw new EstadioException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar un estadio en la BBDD
     * @param estadio a insertar
     * @throws PersistenciaException error controlado
     * @throws EstadioException
     */
    public void insertarEstadio(Estadio estadio) throws PersistenciaException, EstadioException {
        validar(estadio);
        estadioModelo.insertar(estadio);
    }

    /**
     * Metodo encargado de eliminar un estadio de la BBDD segun su id
     * @param id del estadio
     * @throws PersistenciaException error controlado
     */
    public void eliminarEstadio(int id) throws PersistenciaException {
        estadioModelo.eliminar(id);
    }

    /**
     * Metodo encargado de modificar un estadio de la BBDD
     * @param estadio a modificar
     * @throws PersistenciaException error controlado
     * @throws EstadioException
     */
    public void modificarEstadio(Estadio estadio) throws PersistenciaException, EstadioException {
        validar(estadio);
        estadioModelo.modificar(estadio);
    }

    /**
     * Metodo encargado de mostrar la informacion de un estadio segun su nombre
     * @param nombre del estadio
     * @return 
     * @throws PersistenciaException error controlado
     */
    public Estadio consultarInformacion(String nombre) throws PersistenciaException {
        return estadioModelo.obtenerEstadio(nombre);
    }

    /**
     * Metodo encargado de consultar la capacidad de un estadio segun su nombre
     * @param nombre del estadio
     * @throws PersistenciaException error controlado
     */
    public Estadio consultarCapacidad(String nombre) throws PersistenciaException {
        return estadioModelo.obtenerCapacidad(nombre);
    }

    /**
     * Metodo encargado de consultar el anio de construccion de un estadio segun su nombre
     * @param nombre del estadio
     * @throws PersistenciaException error controlado
     */
    public Estadio consultarAnioConstruccion(String nombre) throws PersistenciaException {
        return estadioModelo.obtenerAnio(nombre);
    }
}