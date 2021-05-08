package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.modelo.EquipoModelo;

public class EquipoController {

    EquipoModelo equipoModelo;

    public EquipoController() {
        if (equipoModelo == null) {
            equipoModelo = new EquipoModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del nombre del equipo
     * 
     * @param nombre a validar
     * @throws JugadorException error controlado
     */
    public void validar(String nombre) throws JugadorException {
        String mensaje = "";
        if (nombre == null) {
            mensaje = "El nombre del estadio no puede ser nulo";
            throw new JugadorException(mensaje);
        }
        if (nombre.length() < 1) {
            mensaje = "El nombre del estadio no puede estar vacio";
            throw new JugadorException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new JugadorException(mensaje);
        }
    }

    public void insertarEquipo() {

    }

    public void modificarEquipo() {

    }

    public void eliminarEquipo() {

    }

    public void consultarInformacion() {

    }

    public void consultarPresupuesto() {

    }

    public void consultarCiudad() {

    }
}
