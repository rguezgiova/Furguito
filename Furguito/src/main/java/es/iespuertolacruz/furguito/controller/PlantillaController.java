package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.JugadorModelo;

public class PlantillaController {

    JugadorModelo jugadorModelo;

    public PlantillaController() throws PersistenciaException {
        if (jugadorModelo == null) {
            jugadorModelo = new JugadorModelo();
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

    public void insertarPalmares() {

    }

    public void modificarPalmares() {

    }

    public void eliminarPalmares() {

    }

    public void consultarInformacion() {

    }

    public void consultarLigas() {

    }

    public void consultarCopas() {

    }
}
