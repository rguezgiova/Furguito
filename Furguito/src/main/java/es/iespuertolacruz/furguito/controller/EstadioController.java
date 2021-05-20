package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.JugadorException;
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
     * Metodo encargado de realizar la validacion del nombre del estadio
     * 
     * @param estadio a validar
     * @throws JugadorException error controlado
     */
    public void validar(String estadio) throws JugadorException {
        String mensaje = "";
        if (estadio == null) {
            mensaje = "El nombre del estadio no puede ser nulo";
            throw new JugadorException(mensaje);
        }
        if (estadio.length() < 1) {
            mensaje = "El nombre del estadio no puede estar vacio";
            throw new JugadorException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new JugadorException(mensaje);
        }
    }

    public void insertarEstadio() {

    }

    public void modificarEstadio() {

    }

    public void eliminarEstadio() {

    }

    public void consultarInformacion() {

    }

    public void consultarCapacidad() {

    }

    public void consultarAnioConstruccion() {

    }
}
