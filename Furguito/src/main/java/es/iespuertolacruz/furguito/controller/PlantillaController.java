package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.PlantillaException;
import es.iespuertolacruz.furguito.modelo.PlantillaModelo;

public class PlantillaController {

    PlantillaModelo plantillaModelo;

    public PlantillaController() {
        if (plantillaModelo == null) {
            plantillaModelo = new PlantillaModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del nombre del jugador
     * 
     * @param nombre a validar
     * @throws PlantillaException error controlado
     */
    public void validar(String nombre) throws PlantillaException {
        String mensaje = "";
        if (nombre == null) {
            mensaje = "El nombre del jugador no puede ser nulo";
            throw new PlantillaException(mensaje);
        }
        if (nombre.length() < 1) {
            mensaje = "El nombre del jugador no puede estar vacio";
            throw new PlantillaException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new PlantillaException(mensaje);
        }
    }

}
