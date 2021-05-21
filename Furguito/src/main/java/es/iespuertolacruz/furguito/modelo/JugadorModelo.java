package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class JugadorModelo {
    SqliteBbdd persistencia;
    private static final String NOMBRE = "Jugadores";
    private static final String CLAVE = "idJugador";

    public JugadorModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(NOMBRE, CLAVE, null, null);
    }

    /**
     * insertar jugador en la tabla
     * 
     * @param jugador a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.insertarJugador(jugador);
    }

    /**
     * Modificar un jugador
     * 
     * @param jugador a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.modificarJugador(jugador);
    }

    /**
     * Elimina a un jugador
     * 
     * @param jugador a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.borrarJugador(jugador);
    }

    /**
     * Consultar informacion de un equipo
     * 
     * @param nombre del equipo a buscar
     * @throws PersistenciaException error controlado
     */
    public void consultarInformacion(String nombre) throws PersistenciaException {
        persistencia.obtenerJugador(nombre);
    }

    /**
     * Consultar los 5 maximos goleadores de la liga
     * 
     * @throws PersistenciaException error controlado
     */
    public void consultarMaximosGoleadores() throws PersistenciaException {
        persistencia.obtenerGoleadores();
    }

    /**
     * Consultar los 10 jugadores mas expulsados de la liga
     * 
     * @throws PersistenciaException error controlado
     */
    public void consultarMasExpulsados() throws PersistenciaException {
        persistencia.obtenerExpulsados();
    }
}