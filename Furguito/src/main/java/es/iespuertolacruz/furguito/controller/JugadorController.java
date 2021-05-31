package es.iespuertolacruz.furguito.controller;

import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.JugadorModelo;

public class JugadorController {
    JugadorModelo jugadorModelo;

    public JugadorController() throws PersistenciaException {
        if (jugadorModelo == null) {
            jugadorModelo = new JugadorModelo();
        }
    }

    /**
     * Metodo encargado de realizar la validacion del objeto jugador
     * 
     * @param jugador a validar
     * @throws JugadorException error controlado
     */
    public void validar(Jugador jugador) throws JugadorException {
        String mensaje = "";
        if (jugador == null) {
            mensaje = "Se esta intentando validar un objeto nulo";
            throw new JugadorException(mensaje);
        }
        if (jugador.getId() <= 0) {
            mensaje += "El id del jugador no puede ser menor o igual a 0 \n";
        }
        if (jugador.getEquipo() == null || jugador.getEquipo().isEmpty()) {
            mensaje += "El equipo del jugador no puede ser nulo o vacio \n";
        }
        if (jugador.getNombre() == null || jugador.getNombre().isEmpty()) {
            mensaje += "El nombre del jugador no puede ser nulo o vacio \n";
        }
        if (jugador.getDorsal() <= 0) {
            mensaje += "El dorsal del jugador no puede ser menor o igual a 0";
        }
        if (!mensaje.isEmpty()) {
            throw new JugadorException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar un jugador en la BBDD
     * 
     * @param jugador a insertar
     * @throws PersistenciaException error controlado
     * @throws JugadorException      error controlado
     */
    public void insertarJugador(Jugador jugador) throws PersistenciaException, JugadorException {
        validar(jugador);
        jugadorModelo.insertar(jugador);
    }

    /**
     * Metodo encargado de eliminar un jugador de la BBDD segun su id
     * 
     * @param id del jugador
     * @throws PersistenciaException error controlado
     */
    public void eliminarJugador(int id) throws PersistenciaException {
        jugadorModelo.eliminar(id);
    }

    /**
     * Metodo encargado de modificar un jugador de la BBDD
     * 
     * @param jugador a modificar
     * @throws PersistenciaException error controlado
     * @throws JugadorException      error controlado
     */
    public void modificarJugador(Jugador jugador) throws PersistenciaException, JugadorException {
        validar(jugador);
        jugadorModelo.modificar(jugador);
    }

    /**
     * Metodo encargado de mostrar la informacion de un jugador segun su nombre
     * 
     * @param nombre del jugador
     * @return lista de jugadores que coincidan con el nombre
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> consultarInformacion(String nombre) throws PersistenciaException {
        return jugadorModelo.obtenerJugador(nombre);
    }

    /**
     * Metodo encargado de mostrar a los maximos goleadores
     * 
     * @return lista de maximos goleadores
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> consultarMaximosGoleadores() throws PersistenciaException {
        return jugadorModelo.obtenerGoleadores();
    }

    /**
     * Metodo encargado de mostrar a los jugadores mas expulsados
     * 
     * @return lista de jugadores mas expulsados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> consultarMasExpulsados() throws PersistenciaException {
        return jugadorModelo.obtenerExpulsados();
    }
}