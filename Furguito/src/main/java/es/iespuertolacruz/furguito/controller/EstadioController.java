package es.iespuertolacruz.furguito.controller;

import es.iespuertolacruz.furguito.exception.PlantillaException;
import es.iespuertolacruz.furguito.modelo.EstadioModelo;

public class EstadioController {

    EstadioModelo estadioModelo;

    public EstadioController() {
        if (estadioModelo == null) {
            estadioModelo = new EstadioModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del nombre del estadio
     * 
     * @param estadio a validar
     * @throws PlantillaException error controlado
     */
    public void validar(String estadio) throws PlantillaException {
        String mensaje = "";
        if (estadio == null) {
            mensaje = "El nombre del estadio no puede ser nulo";
            throw new PlantillaException(mensaje);
        }
        if (estadio.length() < 1) {
            mensaje = "El nombre del estadio no puede estar vacio";
            throw new PlantillaException(mensaje);
        }
        if (!mensaje.isEmpty()) {
            throw new PlantillaException(mensaje);
        }
    }

}
