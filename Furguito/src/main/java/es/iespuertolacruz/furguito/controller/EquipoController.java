package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.PlantillaException;
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
     * @throws PlantillaException error controlado
     */
    public void validar(String nombre) throws PlantillaException {
        String mensaje = "";
        if (nombre == null) {
            mensaje = "El nombre del estadio no puede ser nulo";
            throw new PlantillaException(mensaje);
        }
        if (nombre.length() < 1) {
            mensaje = "El nombre del estadio no puede estar vacio";
            throw new PlantillaException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new PlantillaException(mensaje);
        }
    }

}
