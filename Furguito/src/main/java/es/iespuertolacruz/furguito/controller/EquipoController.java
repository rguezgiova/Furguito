package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.EquipoException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.EquipoModelo;

public class EquipoController {
    EquipoModelo equipoModelo;

    public EquipoController() throws PersistenciaException {
        if (equipoModelo == null) {
            equipoModelo = new EquipoModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del objeto equipo
     * 
     * @param equipo a validar
     * @throws EquipoException error controlado
     */
    public void validar(Equipo equipo) throws EquipoException {
        String mensaje = "";
        if (equipo == null) {
            mensaje = "Se esta intentando validar un objeto nulo";
            throw new EquipoException(mensaje);
        }
        if (equipo.getId() <= 0) {
            mensaje += "El id del equipo no puede ser menor o igual a 0 \n";
        }
        if (equipo.getNombre() == null || equipo.getNombre().isEmpty()) {
            mensaje += "El nombre del equipo no puede ser nulo o vacio \n";
        }
        if (equipo.getCiudad() == null || equipo.getCiudad().isEmpty()) {
            mensaje += "La ciudad del equipo no puede ser nula o vacia \n";
        }
        if (equipo.getEstadio() == null || equipo.getEstadio().isEmpty()) {
            mensaje += "El estadio del equipo no puede ser nulo o vacio \n";
        }
        if (equipo.getColores() == null || equipo.getColores().isEmpty()) {
            mensaje += "Los colores del equipo no puede ser nulo o vacio";
        }
        if (!mensaje.isEmpty()) {
            throw new EquipoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar un equipo en la BBDD
     * 
     * @param equipo a insertar
     * @throws PersistenciaException error controlado
     * @throws EquipoException       error controlado
     */
    public void insertarEquipo(Equipo equipo) throws PersistenciaException, EquipoException {
        validar(equipo);
        equipoModelo.insertar(equipo);
    }

    /**
     * Metodo encargado de eliminar un equipo de la BBDD segun su id
     * 
     * @param id del equipo
     * @throws PersistenciaException error controlado
     */
    public void eliminarEquipo(int id) throws PersistenciaException {
        equipoModelo.eliminar(id);
    }

    /**
     * Metodo encargado de modificar un equipo de la BBDD
     * 
     * @param equipo a modificar
     * @throws PersistenciaException error controlado
     * @throws EquipoException       error controlado
     */
    public void modificarEquipo(Equipo equipo) throws PersistenciaException, EquipoException {
        validar(equipo);
        equipoModelo.modificar(equipo);
    }

    /**
     * Metodo encargado de mostrar la informacion de un equipo segun su nombre
     * 
     * @param nombre del equipo
     * @return
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarInformacion(String nombre) throws PersistenciaException {
        return equipoModelo.obtenerEquipo(nombre);
    }

    /**
     * Metodo encargado de mostrar la ciudad de un club segun su nombre
     * 
     * @param nombre del equipo
     * @return
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarCiudad(String nombre) throws PersistenciaException {
        return equipoModelo.consultarCiudad(nombre);
    }

    /**
     * Metodo encargado de mostrar el presupuesto de un club segun su nombre
     * 
     * @param nombre del equipo
     * @return
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarPresupuesto(String nombre) throws PersistenciaException {
        return equipoModelo.consultarPresupuesto(nombre);
    }
}