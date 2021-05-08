package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.modelo.JugadorModelo;

public class JugadorController {

    JugadorModelo plantillaModelo;

    public JugadorController() {
        if (plantillaModelo == null) {
            plantillaModelo = new JugadorModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del nombre del jugador
     * 
     * @param nombre a validar
     * @throws JugadorException error controlado
     */
    public void validar(String nombre) throws JugadorException {
        String mensaje = "";
        if (nombre == null) {
            mensaje = "El nombre del jugador no puede ser nulo";
            throw new JugadorException(mensaje);
        }
        if (nombre.length() < 1) {
            mensaje = "El nombre del jugador no puede estar vacio";
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