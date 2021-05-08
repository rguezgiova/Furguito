package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.modelo.PalmaresModelo;

public class PalmaresController {

    PalmaresModelo palmaresModelo;

    public PalmaresController() {
        if (palmaresModelo == null) {
            palmaresModelo = new PalmaresModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del nombre del equipo
     * 
     * @param equipo a validar
     * @throws JugadorException error controlado
     */
    public void validar(String equipo) throws JugadorException {
        String mensaje = "";
        if (equipo == null) {
            mensaje = "El nombre del equipo no puede ser nulo";
            throw new JugadorException(mensaje);
        }
        if (equipo.length() < 1) {
            mensaje = "El nombre del equipo no puede estar vacio";
            throw new JugadorException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new JugadorException(mensaje);
        }
    }

    public void insertarJugador() {

    }

    public void modificarJugador() {

    }

    public void eliminarJugador() {

    }

    public void consultarInformacion() {

    }

    public void consultarMaximoGoleador() {

    }

    public void consultarMasExpulsado() {

    }
}
