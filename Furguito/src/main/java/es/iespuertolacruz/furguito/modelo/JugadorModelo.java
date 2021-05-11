package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class JugadorModelo {
    SqliteBbdd persistencia;

    public JugadorModelo() {
        persistencia = new SqliteBbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
    }

    public void insertarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.insertarJugador(jugador);
    }

    public void modificarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.modificarJugador(jugador);
    }

    public void eliminarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.borrarJugador(jugador);
    }

    public void consultarInformacion(String nombre) throws PersistenciaException {
        persistencia.obtenerJugador(nombre);
    }

    public void consultarMaximoGoleador() {
        
    }

    public void consultarMasExpulsado() {

    }
}