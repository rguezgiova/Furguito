package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PalmaresException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.PalmaresModelo;

public class PalmaresController {
    PalmaresModelo palmaresModelo;

    public PalmaresController() throws PersistenciaException {
        if (palmaresModelo == null) {
            palmaresModelo = new PalmaresModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del obtejo palmares
     * 
     * @param palmares a validar
     * @throws PalmaresException error controlado
     */
    public void validar(Palmares palmares) throws PalmaresException {
        String mensaje = "";
        if (palmares == null) {
            mensaje = "No se puede validar un objeto nulo";
            throw new PalmaresException(mensaje);
        }
        if (palmares.getId() <= 0) {
            mensaje += "El id del palmares no puede ser menor o igual a 0 \n";
        }
        if (palmares.getEquipo() == null || palmares.getEquipo().isEmpty()) {
            mensaje += "El nombre del equipo referente al palmares no puede ser nulo o vacio";
        }
        if (!mensaje.isEmpty()) {
            throw new PalmaresException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar un palmares en la BBDD
     * @param palmares a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarPalmares(Palmares palmares) throws PersistenciaException {
        palmaresModelo.insertar(palmares);
    }

    /**
     * Metodo encargado de eliminar un palmares de la BBDD segun su id
     * @param id del palmares
     * @throws PersistenciaException error controlado
     */
    public void eliminarPalmares(int id) throws PersistenciaException {
        palmaresModelo.eliminar(id);
    }

    /**
     * Metodo encargado de modificar un palmares de la BBDD
     * @param palmares a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarPalmares(Palmares palmares) throws PersistenciaException {
        palmaresModelo.modificar(palmares);
    }

    /**
     * Metodo encargado de mostrar el palmares de un equipo
     * @param equipo para consultar su palmares
     * @throws PersistenciaException error controlado
     */
    public void consultarPalmares(String equipo) throws PersistenciaException {
        palmaresModelo.palmaresEquipo(equipo);
    }

    /**
     * Metodo encargado de mostrar los equipos con mas ligas
     * @throws PersistenciaException error controlado
     */
    public void consultarLigas() throws PersistenciaException {
        palmaresModelo.palmaresCopas();
    }

    /**
     * Metodo encargado de mostrar los equipos con mas copas
     * @throws PersistenciaException error controlado
     */
    public void consultarCopas() throws PersistenciaException {
        palmaresModelo.palmaresLigas();
    }
}