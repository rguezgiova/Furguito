package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.PlantillaException;
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
     * @throws PlantillaException error controlado
     */
    public void validar(String equipo) throws PlantillaException {
        String mensaje = "";
        if (equipo == null) {
            mensaje = "El nombre del equipo no puede ser nulo";
            throw new PlantillaException(mensaje);
        }
        if (equipo.length() < 1) {
            mensaje = "El nombre del equipo no puede estar vacio";
            throw new PlantillaException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new PlantillaException(mensaje);
        }
    }

}
